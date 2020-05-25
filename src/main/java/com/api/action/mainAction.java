package com.api.action;

import com.api.entity.*;
import com.api.entity.MQTTResult.PrePayCoupon;
import com.api.entity.carOwer.HouseholdBillRequest;
import com.api.entity.carOwer.HouseholdCheckRequest;
import com.api.entity.carOwer.HouseholdFeedbackRequest;
import com.api.enums.ActionRspEnum;
import com.api.exception.ActionRspException;
import com.api.service.*;
import com.api.util.ActionRspUtil;
import com.api.util.DateUtil;
import com.api.util.JsonUtil;
import com.api.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.api.util.MQTT.MqttPushClient;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 10:152018-4-28
 * @Modified By:
 */
@RestController
public class mainAction {
        private  static final Logger logger= LoggerFactory.getLogger(mainAction.class);
    @Autowired
    private APILicenseService apiLicenseService;
    @Autowired
    private GlobalInfoService globalInfoService;
    @Autowired
    private BusineCouponService busineCouponService;
    @Autowired
    private MqttBaseService mqttBaseService;
    @Autowired
    private ParkInOutService parkInOutService;
    @Autowired
    private GovUploadService govUploadService;
    @Autowired
    private CompanyParkService companyParkService;
    @Autowired
    private MqttClientInsideService mqttClientInsideService;
    @Autowired
    private PropertyHouseholdInfoService propertyHouseholdInfoService;
    @Autowired
    private  PropertyHouseholdBillService propertyHouseholdBillService;
    @Autowired
    private  HouseholdFeedbackServcie householdFeedbackServcie;
    /**
     * 第三方API主入口
     * @param actionReq
     * @param bindingResult
     * @return
     * @throws Exception
     */

        @PostMapping(value = "/mainAction")
        public ActionRsp mainAction(@Valid final ActionReq actionReq, final BindingResult bindingResult) throws Exception {
            logger.info(Thread.currentThread().getName()+"进入mainAction方法");
        /*    Callable callable=new Callable() {*/
                boolean license = apiLicenseService.theThirdAPILicense(actionReq.getID(),actionReq.getKey());
              /*  @Override
                public ActionRsp call() throws Exception {*/
                    //实例化返回车易泊数据实体类
                   String result="";
                    logger.info(Thread.currentThread().getName()+"进入call方法");
                    //try{
                        logger.info(actionReq.toString());
                        /**
                         * 验证访问数据格式是否正确
                         */
                        if(bindingResult.hasErrors()){
                            /*actionRsp.setCode(3);
                            actionRsp.setMessage(bindingResult.getFieldError().getDefaultMessage());*/
                            logger.info("the format is error,time is"+ DateUtil.getCurrDateTime());
                            throw  new ActionRspException(ActionRspEnum.FORMAT_ERROR);
                        }else if (!license){
                            throw  new ActionRspException(ActionRspEnum.LICENSE_ERROR);
                        }
                        else
                        {
                            SessionUtil.setParkId(actionReq.getParkId());//设置当前请求车场ID至session
                            switch (actionReq.getService()){
                                    //获取某停车场全部配置信息
                                case "tGlobalInfoDownload":
                                    List<TGlobalInfo> tGlobalInfoList = globalInfoService.getGlobalInfoByParkid(actionReq.getParkId());
                                    result=JsonUtil.listToJson(tGlobalInfoList);
                                    break;
                                    //更新停车场配置信息
                                case"tGlobalInfoUpload":
                                    List<TGlobalInfo> tGlobalInfos = JsonUtil.json2List(actionReq.getData().toString(), TGlobalInfo.class);
                                    Integer success = globalInfoService.insertOrUpdateGlobalInfo(tGlobalInfos);
                                    if (success==tGlobalInfos.size()){
                                        result="成功上传云端";
                                    }else {
                                        result="成功"+success+"条，失败"+(tGlobalInfos.size()-success)+"条";
                                    }
                                    break;
                                    //扫码获取电子券的全部信息
                                case "getWeChatCoupon":
                                    String msg = busineCouponService.getElectronicTicket(JsonUtil.jsonToBean(actionReq.getData().toString(),BusineCouponGetTicketInfo.class));
                                    if (msg.equals("ticketId不合法")){
                                        throw  new ActionRspException(ActionRspEnum.UNKONW_ERROR);
                                    }
                                    result=msg;
                                    break;
                                    //获取第三方优惠
                                case "getThirdCoupon":
                                    PrePayCoupon prePayCoupon=JsonUtil.jsonToBean(actionReq.getData().toString(), PrePayCoupon.class);
                                    //theThirdCoupon.setCarPlate(StringUtil.unicodeToChinas(theThirdCoupon.getCarPlate()));//unicode编码解包
                                    result=busineCouponService.SendPrePayCoupon(prePayCoupon);
                                    break;
                                    //通过线下获取临时车应缴费用
                                case"getCarFeeRequst":
                                    Map map=new HashMap();
                                    map=JsonUtil.json2Map(actionReq.getData().toString());
                                    result=mqttBaseService.getCarFeeRequst(map,actionReq.getParkId());
                                    break;
                                    //商户下发优惠
                                case"transferBusinCoupon":
                                    result=busineCouponService.transferBusineCoupon(JsonUtil.jsonToBean(actionReq.getData().toString(), BusineCouponUpload.class));
                                    //System.out.printf("actionRsp"+JsonUtil.beanToJson(actionRsp));
                                    break;
                                    //修改开票状态
                                case"noticeBillingStatus":
                                    result=parkInOutService.updateBillingStatus(actionReq.getParkId(),actionReq.getData().toString());
                                    break;
                                    //交警平台获取进出流水
                                case "getGovUnUploadRec":
                                    result=JsonUtil.listToJson(govUploadService.getGovParkInOut(actionReq.getParkId()));
                                    break;
                                    //修改上传标识
                                case"updateGovUpFlag":
                                    govUploadService.updateGovUpFlag(actionReq.getParkId(),JsonUtil.json2List(actionReq.getData().toString(), GovParkInOut.class));
                                    break;
                                    //获取停车场信息
                                case "getCompanyParkInfo":
                                    result=govUploadService.getCompanyParkInfo(actionReq.getParkId());
                                    break;
                                    //铜仁公安获取停车数据
                                case "TRPolicePark":
                                    Map mapTr = JsonUtil.json2Map(actionReq.getData().toString());
                                    result=parkInOutService.getTRPoliceParkInOut(mapTr.get("startDateTime").toString(),mapTr.get("endDateTime").toString(),Integer.valueOf(mapTr.get("page").toString()),Integer.valueOf(mapTr.get("rows").toString()),mapTr.get("gg_ssjgbm_1").toString());
                                    break;
                                    //接收cloud数据
                                case "getCloudData":
                                    CloudData cloudData=JsonUtil.jsonToBean(actionReq.getData().toString(), CloudData.class);
                                    logger.warn(cloudData.toString());
                                    result=parkInOutService.SaveCloudData(cloudData);
                                    break;
                                case "SendCoupon":
                                    result=busineCouponService.SendCoupon(actionReq.getParkId());
                                    //批量修改车易泊云端流水开票状态
                                case "noticeBillingStatusALL":
                                    Integer parkId = actionReq.getParkId();
                                    result=parkInOutService.noticeBillingStatusALL(parkId,actionReq.getData().toString());
                                    break;
                                    //批量获取车易泊云端流水
                                case "getParkInOut":
                                    result=parkInOutService.getParkInOut(actionReq.getParkId(),actionReq.getData().toString()).toString();
                                    break;
                                    //获取车场车位数
                                case "getParkSpaces":
                                    result =JsonUtil.mapToJson(companyParkService.getParkSpaces(actionReq.getParkId()));
                                    break;
                                    //接收住户审核信息
                                case "householdCheck":
                                    HouseholdCheckRequest householdCheckRequest=JsonUtil.jsonToBean(actionReq.getData().toString(), HouseholdCheckRequest.class);
                                    result=propertyHouseholdInfoService.HouseholdCheck(householdCheckRequest);
                                    //接收住户账单支付信息
                                case "householdBillRequest":
                                    HouseholdBillRequest householdBillRequest=JsonUtil.jsonToBean(actionReq.getData().toString(), HouseholdBillRequest.class);
                                    result=propertyHouseholdBillService.HouseholdBillget(householdBillRequest);
                                    //接收住户意见反馈
                                case "householdFeedbackRequest":
                                    HouseholdFeedbackRequest householdFeedbackRequest=JsonUtil.jsonToBean(actionReq.getData().toString(), HouseholdFeedbackRequest.class);
                                    result=householdFeedbackServcie.HouseholdFeedback(householdFeedbackRequest);
                                    //车辆预约
                                case "reservedCar":
                                    Map mapRe=JsonUtil.json2Map(actionReq.getData().toString());
                                    result=mqttClientInsideService.reservedCar(mapRe);
                                default:
                                    logger.info("can not find this Service,ServiceName:"+actionReq.getService()+" time is"+ DateUtil.getCurrDateTime());
                                    break;
                                    //throw  new ActionRspException(ActionRspEnum.FIND_ERROR);
                            }
                        }
                   /* }
                    catch (Exception e){
                        logger.info("error:"+e.toString()+"time is "+e.toString());

                        //throw  new ActionRspException(ActionRspEnum.UNKONW_ERROR);
                    }*/
                    //String result=JsonUtil.beanToJson(actionRsp);
                    logger.info(Thread.currentThread().getName()+"从parkOrderService方法返回");
                     //response = new HttpServletResponse();
                   /* response.setHeader("Access-Control-Allow-Origin","*");
                    response.setHeader("Content-type", "text/html;charset=UTF-8");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(result);*/
                    return ActionRspUtil.Success(result);
              /*  }
            };
            return  callable;*/
    }

}
