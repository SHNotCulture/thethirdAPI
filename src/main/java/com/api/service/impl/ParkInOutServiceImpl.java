package com.api.service.impl;

import com.api.dao.CustomizeMapper;
import com.api.dao.TParkInOutMapper;
import com.api.dao.TTrPoliceMapper;
import com.api.entity.*;
import com.api.enums.ActionRspEnum;
import com.api.exception.ActionRspException;
import com.api.service.CompanyParkService;
import com.api.service.ParkCarService;
import com.api.service.ParkInOutService;
import com.api.util.DateUtil;
import com.api.util.JsonUtil;
import com.api.util.PageBean;
import com.github.pagehelper.PageHelper;
import com.google.gson.JsonArray;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParkInOutServiceImpl implements ParkInOutService {
    private  static final Logger logger= LoggerFactory.getLogger(ParkInOutServiceImpl.class);
    @Autowired
    private CustomizeMapper customizeMapper;
    @Autowired
    private TTrPoliceMapper tTrPoliceMapper;
    @Autowired
    private TParkInOutMapper tParkInOutMapper;
    @Autowired
    private ParkCarService parkCarService;
    @Autowired
    private CompanyParkService companyParkService;

    /**
     * 设置查询条件
     * @param tParkInOut
     * @return
     */
    private TParkInOutCriteria setCriteria(TParkInOut tParkInOut, String beginTime, String endTime){
        TParkInOutCriteria tParkInOutCriteria= new TParkInOutCriteria();
        try {
        if(tParkInOut!=null){
            TParkInOutCriteria.Criteria criteria=tParkInOutCriteria.createCriteria();
            if(tParkInOut.getParkId()!=null){
                criteria.andParkIdEqualTo(tParkInOut.getParkId());
            }
            if(tParkInOut.getOrderId()!=null){
                criteria.andOrderIdEqualTo(tParkInOut.getOrderId());
            }
            if(beginTime!=null && endTime!=null){
                criteria.andOutTimeBetween(beginTime+" 00:00:00",endTime+" 23:59:59");
            }
            if(tParkInOut.getInCarPlate()!=null){
                criteria.andInCarPlateEqualTo(tParkInOut.getInCarPlate());
            }
            if(tParkInOut.getBillingStatus()!=null){
                criteria.andBillingStatusEqualTo(tParkInOut.getBillingStatus());
            }
        }
        }catch (Exception e){

        }
        return  tParkInOutCriteria;
    }
    /**
     * 获取数据总量
     * @param tParkInOut
     * @return
     */
    private Integer getCount(TParkInOut tParkInOut, String beginTime, String endTime){
        Integer total =(int)tParkInOutMapper.countByExample(setCriteria(tParkInOut,null,null));
        return total;
    }
    /**
     *查询停车流水信息(分页)
     * @param tParkInOut
     * @param page
     * @param limit
     * @return
     */
    public PageBean<TParkInOut> getTParkInOutbyPage(TParkInOut tParkInOut, Integer page, Integer limit, String beginTime, String endTime){
        PageHelper.startPage(page, limit,"in_time desc");
        List<TParkInOut> tParkInOuts=getTParkInOut(tParkInOut,beginTime,endTime);
        Integer countNums =getCount(tParkInOut,beginTime,endTime);
        PageBean<TParkInOut> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tParkInOuts);
        return pageData;
    }
    /**
     * 查询停车流水信息
     * @return
     */
    public List<TParkInOut> getTParkInOut(TParkInOut tParkInOut, String beginTime, String endTime){
        List<TParkInOut> tParkInOuts=tParkInOutMapper.selectByExample(setCriteria(tParkInOut, beginTime, endTime));
        return tParkInOuts;
    }


    /**
     * 更新停车流水信息
     * @param tParkInOut
     * @return
     */
    public String UpdateTParkInOut(TParkInOut tParkInOut)
    {
        logger.info(tParkInOut.toString());
        if(tParkInOut.getId()!=null){
            tParkInOutMapper.updateByPrimaryKeySelective(tParkInOut);
        }
        else
        {
            tParkInOutMapper.insertSelective(tParkInOut);
        }
        return "更新成功";
    }

    /**
     * 保存cloud支付数据
     * @param cloudData
     * @return
     */
    public String SaveCloudData(CloudData cloudData){
        if(cloudData!=null){
            TCompanyPark tCompanyPark=new TCompanyPark();
            tCompanyPark.setId(Integer.valueOf(cloudData.getParkingId()));
            List<TCompanyPark> tCompanyParks= companyParkService.getTCompanyPark(tCompanyPark);
            if(tCompanyParks.size()>0){
                TParkInOut tParkInOut=new TParkInOut();
                tParkInOut.setOrderId(cloudData.getBillNo());
                tParkInOut.setParkId(Integer.valueOf(cloudData.getParkingId()));
                //查询是否存在相应流水数据
                List<TParkInOut> tParkInOuts=getTParkInOut(tParkInOut,null,null);
                if(tParkInOuts.size()>0){
                     tParkInOut=tParkInOuts.get(0);
                     //tParkInOut.setOrderId(cloudData.getOrderId());
                     tParkInOut.setCloudOrderId(cloudData.getOrderId());
                     tParkInOut.setSettleDate(cloudData.getSettleDate());
                     UpdateTParkInOut(tParkInOut);
                }
                else
                {
                    throw new ActionRspException(ActionRspEnum.CLOUDDATA_ERROR);
                }
            }
            else
            {
            throw new ActionRspException(ActionRspEnum.PARK_ERROR);
            }
        }
        return "同步成功";
    }

    /**
     * 修改流水开票状态
     * @param parkId
     * @param data
     * @return
     */
    @Override
    public String updateBillingStatus(Integer parkId,String data) {
        String msg;
        Map map =  JsonUtil.json2Map(data);
        TParkInOut tParkInOut = new TParkInOut();
        tParkInOut.setParkId(parkId);
        tParkInOut.setInCarPlate(map.get("carNo").toString());
        /*tParkInOut.setInTime(map.get("enterTime").toString());
        tParkInOut.setOutTime(map.get("outTime").toString());*/
        tParkInOut.setBillingStatus(map.get("tradeCode").toString());
        tParkInOut.setOrderId(map.get("tradeid").toString());
        customizeMapper.updateBillingStatusByParkIdCarplateInOuttime(tParkInOut);
        msg = "修改开票状态成功";
        return msg;
    }

    @Override
    public String getTRPoliceParkInOut(String startDateTime, String endDateTime, Integer page, Integer rows, String gg_ssjgbm_1) {
        String msg;
        if (DateUtil.getInterval(startDateTime,endDateTime,3)<=10){
        TTrPoliceCriteria tTrPoliceCriteria = new TTrPoliceCriteria();
        TTrPoliceCriteria.Criteria criteria = tTrPoliceCriteria.createCriteria();
        criteria.andGgSsjgbm1EqualTo(gg_ssjgbm_1);
        List<TTrPolice> tTrPolices = tTrPoliceMapper.selectByExample(tTrPoliceCriteria);
        if (tTrPolices.size()>0) {
            TTrPolice tTrPolice = tTrPolices.get(0);
            Integer totalNum = customizeMapper.getTRParkInOutCount(tTrPolice.getParkId(), startDateTime, endDateTime);
            if (totalNum != 0) {
            JSONArray jsonArray = new JSONArray();
            Integer ys;
            if (totalNum % rows == 0) {
                //可以整除
                ys = totalNum / rows;
            } else {
                ys = (totalNum / rows) + 1;
            }
            if (page <= ys) {
                List<TParkInOut> parkInOutList = customizeMapper.getTRParkInOut(tTrPolice.getParkId(), startDateTime, endDateTime, "limit " + ((page - 1) * rows) + 1 + "," + page * rows + "");
                for (TParkInOut tParkInOut : parkInOutList) {
                    Map map = new HashMap();
                    map.put("id", tParkInOut.getId());
                    map.put("x_zb", tTrPolice.getxZb());
                    map.put("y_zb", tTrPolice.getyZb());
                    map.put("gg_ssjgbm_1", tTrPolice.getGgSsjgbm1());
                    map.put("gg_ssjgbm_1_mc", tTrPolice.getGgSsjgbm1Mc());
                    map.put("gg_ssjgbm_2", tTrPolice.getGgSsjgbm2());
                    map.put("gg_ssjgbm_2_mc", tTrPolice.getGgSsjgbm2Mc());
                    map.put("gg_ssjgbm_3", tTrPolice.getGgSsjgbm3());
                    map.put("gg_ssjgbm_3_mc", tTrPolice.getGgSsjgbm3Mc());
                    map.put("lxdh", tTrPolice.getLxdh());
                    map.put("lxr", tTrPolice.getLxr());
                    map.put("chpys", tTrPolice.getChpys());
                    map.put("chllx", tTrPolice.getChllx());
                    map.put("djr_xm", tTrPolice.getDjrXm());
                    map.put("cjr", tTrPolice.getCjr());
                    map.put("hylxdm", tTrPolice.getHylxdm());
                    map.put("hylx", tTrPolice.getHylx());
                    map.put("chlpp", "");//无法识别
                    map.put("chshys", "");//无法识别
                    map.put("chzhsfz", "");//暂无数据
                    map.put("kh", "");//没有卡号
                    map.put("tchlx", "");//停车类型  小区，工厂，行政单位，商场 无法识别
                    if (tParkInOut.getCarNature() == 2) {
                        TParkCar tParkCar = parkCarService.getParkCarInfoByCarPlateAndParkId(tTrPolice.getParkId(), tParkInOut.getInCarPlate());
                        if (tParkCar != null) {
                            map.put("chzhxm", tParkCar.getRealname());
                            map.put("chzhlxdh", tParkCar.getPhone());
                        } else {
                            map.put("chzhxm", "");
                            map.put("chzhlxdh", "");
                        }
                    }
                    if (tParkInOut.getOutTime() == null) {
                        //进场
                        map.put("cph", tParkInOut.getInCarPlate());
                        map.put("fxfs", "自动");
                        map.put("tgsj", tParkInOut.getInTime());
                        map.put("gchfx", "正常进入");
                        map.put("cjrq", tParkInOut.getInTime());
                    } else {
                        //出场
                        map.put("cph", tParkInOut.getOutCarPlate());
                        if (tParkInOut.getOutType() == 1) {
                            //月租车放行
                            map.put("fxfs", "自动");
                        } else {
                            map.put("fxfs", "手动");
                        }

                        map.put("tgsj", tParkInOut.getOutTime());
                        map.put("gchfx", "正常外出");
                        map.put("cjrq", tParkInOut.getOutTime());
                    }
                    jsonArray.add(JSONObject.fromObject(JsonUtil.mapToJson(map)));
                }
                Map mapMsg = new HashMap();
                mapMsg.put("total", totalNum);
                mapMsg.put("rows", jsonArray);
                msg  = JsonUtil.mapToJson(mapMsg);
            }else {
                msg = "该页码不存在";
            }
        }else {
                msg = "该查询条件下暂无数据";
            }
        }else {
            msg = "该网点不存在";
        }
        }else {
            msg = "只允许查询十天间隔的数据";
        }
        return msg;
    }

    @Override
    public String noticeBillingStatusALL(Integer parkId,String strData) {

        JSONArray jsonArray = JSONArray.fromObject(strData);
        Integer num = 0;
        for(Object data:jsonArray){
            if (updateBillingStatus(parkId,JsonUtil.beanToJson(data))=="修改开票状态成功"){
                num++;
            }
        }
        String msg="批量修改开票状态成功"+num+"条";
        return msg;
    }

    @Override
    public JsonArray getParkInOut(Integer parkId,String strData) {
        JsonArray jsonArray = new JsonArray();
        Map<String,String> map = JsonUtil.json2Map(strData.toString());
        String inCarPlate = map.get("carPlate");
        String beginTime = map.get("beginTime");
        String endTime = map.get("endTime");
        TParkInOut tParkInOut = new TParkInOut();
        tParkInOut.setInCarPlate(inCarPlate);
        tParkInOut.setBillingStatus("10000");
        List<TParkInOut> tParkInOutList = getTParkInOutbyPage(tParkInOut,1,30,beginTime,endTime).getItems();
        for(Integer i=0;i<tParkInOutList.size();i++){
            JSONObject Json = new JSONObject();
            String orderId = tParkInOutList.get(i).getOrderId();
            String carPlate = tParkInOutList.get(i).getInCarPlate();
            String inTime = tParkInOutList.get(i).getInTime();
            String outTime = tParkInOutList.get(i).getOutTime();
            if(outTime==null){
                outTime="null";
            }
                Double actualFee = tParkInOutList.get(i).getActualPay() + tParkInOutList.get(i).getBeforePay() + tParkInOutList.get(i).getQpassPay();
                Json.put("orderId", orderId);
                Json.put("carPlate", carPlate);
                Json.put("inTime", inTime);
                Json.put("outTime", outTime);
                Json.put("actualFee", actualFee);
                jsonArray.add(Json.toString());

        }

        return jsonArray;

    }


}
