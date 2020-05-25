package com.api.service.impl;

import com.api.dao.*;
import com.api.entity.*;
import com.api.entity.MQTTResult.PrePayCoupon;
import com.api.entity.MQTTResult.TheThirdCoupon;
import com.api.enums.ActionRspEnum;
import com.api.exception.ActionRspException;
import com.api.service.*;
import com.api.util.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author jin
 * @Data 2019/4/11 16:31
 **/
@Service
public class BusineCouponServiceImpl implements BusineCouponService {
    private  static final Logger logger= LoggerFactory.getLogger(BusineCouponServiceImpl.class);

    @Autowired
    private TBusineTicketMapper tBusineTicketMapper;
    @Autowired
    private TElectronicTicketMapper tElectronicTicketMapper;
    @Autowired
    private CustomizeMapper customizeMapper;
    @Autowired
    private TBusineMapper tBusineMapper;
    @Autowired
    private TCompanyParkMapper tCompanyParkMapper;
    @Autowired
    private TBusinesCouponMapper tBusinesCouponMapper;
    @Autowired
    private TCompanyMapper tCompanyMapper;
    @Autowired
    private TTicketCouponMapper tTicketCouponMapper;
    @Autowired
    private TConponQrcodeMapper tConponQrcodeMapper;
    @Autowired
    private MonthlyCarService monthlyCarService;
    @Autowired
    private BusineService busineService;
    @Autowired
    private MqttBaseService mqttBaseService;
    @Autowired
    private CompanyParkService companyParkService;


    @Override
    public String getElectronicTicket(BusineCouponGetTicketInfo busineCouponGetTicketInfo) {
        String msg="ticketId不合法";
        if (busineCouponGetTicketInfo.getTicketId()!=null){
            //根据ticket_id查询改商户最接近过期的电子券批次号
            Integer busineTicketId = customizeMapper.getTBusineTicketExpireSoon(busineCouponGetTicketInfo);
            Map map = StringUtil.object2Map(tElectronicTicketMapper.selectByPrimaryKey(busineCouponGetTicketInfo.getTicketId()));
            map.put("busineTicketId",busineTicketId);
            msg = JsonUtil.mapToJson(map);
        }
        return msg;
    }

    @Override
    public String transferBusineCoupon(BusineCouponUpload busineCouponUpload) {
        try {
        String msg = "优惠成功";
        logger.info("进入优惠流程，参数："+JsonUtil.beanToJson(busineCouponUpload));
        Integer couponType = busineCouponUpload.getCouponType();
        Integer parkId = busineCouponUpload.getParkId();
        Integer busineId = busineCouponUpload.getBusineId();
        Double couponPay = busineCouponUpload.getCouponPay();
        String carPlate = busineCouponUpload.getCarPlate();
        Integer ticketId = busineCouponUpload.getTicketId();
        String inTime = busineCouponUpload.getInTime();
        TBusine tBusine = tBusineMapper.selectByPrimaryKey(busineId);
        TCompany tCompany = tCompanyMapper.selectByPrimaryKey(tBusine.getCompanyId());
        Integer carPlateLen = carPlate.length();
        TParkInOut tParkInOut;
        if (!StringUtils.isBlank(busineCouponUpload.getOrderId())){
            tParkInOut = customizeMapper.getParkinoutByOrderId(parkId,busineCouponUpload.getOrderId());
        }else {
            tParkInOut = customizeMapper.getRecentParkinout(parkId, carPlate.substring(1,carPlateLen),inTime);
        }
        Integer isManyPreferential = tCompany.getIsManyPreferential();
        Shop shop = new Shop();
        shop.setCoupon_money(couponPay);
        shop.setCar_num(StringUtil.enCode(carPlate));
        shop.setMerchant_Id(busineId);
        shop.setMerchant_name(StringUtil.enCode(tBusine.getBusineName()));
        shop.setDiscount_time(DateUtil.getCurDateTime());
        shop.setPaymode(CommonUtil.OUT_TYPE_7);
        shop.setCoupon_type(couponType);
        TBusinesCoupon tBusinesCouponJudge = new TBusinesCoupon();
        tBusinesCouponJudge.setCarPlate(busineCouponUpload.getCarPlate());
        tBusinesCouponJudge.setInTime(inTime);
        tBusinesCouponJudge.setParkId(parkId);
        TTicketCoupon tTicketCouponJudge = new TTicketCoupon();
        tTicketCouponJudge.setCarplate(carPlate);
        tTicketCouponJudge.setParkId(parkId);
        tTicketCouponJudge.setInTime(inTime);
        TBusineTicket tBusineTicket = tBusineTicketMapper.selectByPrimaryKey(busineCouponUpload.getBusineTicketId());
        List<TBusinesCoupon> tBusinesCouponList = tBusinesCouponMapper.selectByExample(getTBusinesCouponCriteria(tBusinesCouponJudge));
        TTicketCoupon tTicketCoupon = tTicketCouponMapper.selectByPrimaryKey(busineCouponUpload.getTicketCouponId());
        List<TTicketCoupon> tTicketCouponList = tTicketCouponMapper.selectByExample(getTTicketCouponCriteria(tTicketCouponJudge));
        TConponQrcode tConponQrcode =new TConponQrcode();
        tConponQrcode.setUseLimit(-1);
        if (busineCouponUpload.getQrcodeId()!=null){
            logger.info("扫码优惠");
            tConponQrcode = tConponQrcodeMapper.selectByPrimaryKey(Integer.valueOf(busineCouponUpload.getQrcodeId()));
        }
        double couponPayByTime;
        if (monthlyCarService.whetherParkCar(parkId,carPlate).size()>0){
            logger.info("车牌为月租车，不能下发优惠");
            throw new ActionRspException(ActionRspEnum.PARKCAR_ERROR);
        }if (tConponQrcode.getUseLimit() == 0 ){
            logger.info("优惠失败,该二维码已失效");
            throw new ActionRspException(ActionRspEnum.QRCODEInvalid_ERROR);
            }
        else{
            switch (couponType) {
                //判断代缴模式
                case 0:
                case 1:
                case 2:
                case 4:
                    //限制金额和时间
                    if (couponType == 1) {
                        couponPayByTime = getTempCarChargeInfo(parkId, carPlate, couponPay,tParkInOut);
                        shop.setCoupon_money(couponPayByTime);
                        logger.info("时间优惠，"+couponPay+"分钟转换为"+couponPayByTime+"元");
                    }
                    //判断允许多次代缴
                    switch (isManyPreferential) {
                        //不允许
                        case 0:
                            if (tBusinesCouponList.size() == 0) {
                                msg = transferMoneyTraditional(parkId, shop, tBusine, null,tParkInOut);
                                logger.info("物业规则为不允许多次代缴。下发金额："+shop.getCoupon_money()+"元。"+msg);
                            } else {
                                logger.info("已下发了优惠,此次优惠无效");
                                throw new ActionRspException(ActionRspEnum.ExistedCoupon_ERROR);
                            }
                            break;
                        //允许
                        case 1:
                            if (tBusinesCouponList.size() == 0) {
                                msg = transferMoneyTraditional(parkId, shop, tBusine, null,tParkInOut);
                            } else {
                                double couponPayNew = shop.getCoupon_money();
                                if (couponPayNew == 999) {
                                    shop.setCoupon_money(couponPayNew);
                                } else {
                                    double couponPayAccumulate=0.00;
                                    for (TBusinesCoupon tBusinesCoupon :tBusinesCouponList){
                                        couponPayAccumulate+=tBusinesCoupon.getCouponPay();
                                    }
                                    shop.setCoupon_money(shop.getCoupon_money() + couponPayAccumulate);
                                }
                                msg = transferMoneyTraditional(parkId, shop, tBusine, couponPayNew,tParkInOut);
                                /*if (msg.equals("优惠成功")) {
                                    transferBusinesCoupon(parkId, shop, null, tBusinesCouponList.get(0));
                                }*/
                            }
                            logger.info("允许多次代缴,下发"+shop.getCoupon_money()+"元。"+msg);
                            break;
                        //允许取最大
                        case 2:
                            if (tBusinesCouponList.size() == 0) {
                                msg = transferMoneyTraditional(parkId, shop, tBusine,null,tParkInOut);
                            } else {
                                TBusinesCoupon tBusinesCoupon = tBusinesCouponList.get(0);
                                if (tBusinesCoupon.getCouponPay() == 0) {
                                    logger.info("已下发全免优惠，此优惠无效");
                                    throw new ActionRspException(ActionRspEnum.Free_ERROR);
                                } else if (tBusinesCoupon.getCouponPay() > 0 && tBusinesCoupon.getCouponPay() >= shop.getCoupon_money()) {
                                    logger.info("已下发更大或相等优惠，此优惠无效");
                                    throw new ActionRspException(ActionRspEnum.MoreCoupon_ERROR);
                                } else if (tBusinesCoupon.getCouponPay() > 0 && tBusinesCoupon.getCouponPay() < shop.getCoupon_money()) {
                                    msg = transferMoneyTraditional(parkId, shop, tBusine,  null,tParkInOut);
                                    if (msg.equals("优惠成功")) {
                                        transferBusinesCoupon(parkId, shop, null, tBusinesCouponList.get(0));
                                    }
                                }
                            }
                            logger.info("多次优惠取最大，下发金额："+shop.getCoupon_money()+"元。"+msg);
                            break;
                        default:
                            break;
                    }
                    break;
                //电子券
                case 3:
                    logger.info("电子券优惠...");
                    if (tTicketCoupon != null) {
                        logger.info("云端发起多天卷");
                        //由云端流水查询存在还可以使用的电子券
                        shop.setMerchant_Id(tTicketCoupon.getBusineId());
                        shop.setMerchant_name(StringUtil.enCode(tTicketCoupon.getBusineName()));
                        shop.setDiscount_time(DateUtil.getCurDateTime());
                        shop.setPaymode(CommonUtil.OUT_TYPE_7);
                        tTicketCoupon.setInTime(inTime);
                        tTicketCoupon.setOutTime("");
                        tTicketCoupon.setUpdateTime(DateUtil.getCurDateTime());
                        if (tTicketCoupon.getCouponType() == 0) {
                            //金额
                            shop.setCoupon_money(tTicketCoupon.getCouponPay());
                            transferMoney(tTicketCoupon.getParkId(), shop,tParkInOut);
                        } else {
                            TElectronicTicket tElectronicTicket = tElectronicTicketMapper.selectByPrimaryKey(ticketId);
                            //时间
                            couponPayByTime = getTempCarChargeInfo(tTicketCoupon.getParkId(), tTicketCoupon.getCarplate(), tElectronicTicket.getTicketValue(),tParkInOut);
                            shop.setCoupon_money(couponPayByTime);
                            transferMoney(tTicketCoupon.getParkId(), shop,tParkInOut);
                            logger.info("电子券时间转换成金额"+tElectronicTicket.getTicketValue()+"分钟->"+couponPayByTime+"元");
                        }
                        tTicketCouponMapper.updateByPrimaryKeySelective(tTicketCoupon);
                    } else { //场内手动被动下发电子券优惠
                        logger.info("手动发起电子券");
                        if (!StringUtils.isBlank(ticketId.toString())) {
                            TElectronicTicket tElectronicTicket = tElectronicTicketMapper.selectByPrimaryKey(ticketId);
                            //判断年月日限制
                            //boolean limit = customizeMapper.getTicketCouponIsUseNum(busineCouponUpload.getBusineTicketId()) == 0 ? true : false;
                            //是否还有余票
                            boolean residue = tBusineTicket.getTicketNum() > 0 ? true : false;
                            //判断年月日限制和余票同时通过
                            if (residue) {
                                //判断代缴类型
                                TTicketCoupon tTicketCouponRecord = new TTicketCoupon();
                                if (tElectronicTicket.getTicketType() == 0) {
                                    //金额
                                    tTicketCouponRecord.setCouponActualPay(tElectronicTicket.getTicketValue());
                                    shop.setCoupon_money(tElectronicTicket.getTicketValue());
                                } else {
                                    //时间
                                    couponPayByTime = getTempCarChargeInfo(parkId, carPlate,tElectronicTicket.getTicketValue(),tParkInOut);
                                    tTicketCouponRecord.setCouponActualPay(couponPayByTime);
                                    shop.setCoupon_money(couponPayByTime);
                                    logger.info("电子券时间转换成金额"+tElectronicTicket.getTicketValue()+"分钟->"+couponPayByTime+"元");
                                }
                                switch (isManyPreferential) {
                                    //不允许
                                    case 0:
                                        //有充值记录
                                        if (tTicketCouponList.size() > 0) {
                                            logger.info("已下发过优惠，只能优惠一次");
                                            throw new ActionRspException(ActionRspEnum.ExistedCoupon_ERROR);
                                        } else {
                                            //保存电子券优惠记录
                                            transferTicketCoupon(busineCouponUpload, tBusine, tCompany, tTicketCouponRecord, tElectronicTicket);
                                            //下发任务
                                            transferMoney(parkId, shop,tParkInOut);
                                            //修改商户电子卷数量
                                            updateBusineTicket(tBusineTicket);
                                            msg = "优惠成功";
                                        }
                                        logger.info("不允许多次代缴,下发金额："+shop.getCoupon_money()+"元。"+msg);
                                        break;
                                    case 1:
                                        //允许
                                        //保存电子券优惠记录
                                        transferTicketCoupon(busineCouponUpload, tBusine, tCompany, tTicketCouponRecord, tElectronicTicket);
                                        //下发任务
                                        double couponMoneyTicketAccumulate=0.00;
                                        for (TTicketCoupon tTicketCouponRecorded : tTicketCouponList){
                                            couponMoneyTicketAccumulate+=tTicketCouponRecorded.getCouponActualPay();
                                        }
                                        shop.setCoupon_money(couponMoneyTicketAccumulate + shop.getCoupon_money());
                                        transferMoney(parkId, shop,tParkInOut);
                                        //修改商户电子卷数量
                                        updateBusineTicket(tBusineTicket);
                                        logger.info("允许多次代缴,下发金额："+shop.getCoupon_money()+"元。"+msg);
                                        break;
                                    case 2:
                                        //允许多次代缴，取最大值
                                        double couponPayMax=0.00;
                                        if (tTicketCouponList.size()>0){
                                            couponPayMax = tTicketCouponList.get(0).getCouponActualPay();
                                        }
                                        if (tTicketCoupon.getCouponPay() > couponPayMax) {
                                            //保存电子券优惠记录
                                            transferTicketCoupon(busineCouponUpload, tBusine, tCompany, tTicketCouponRecord, tElectronicTicket);
                                            //下发
                                            shop.setCoupon_money(shop.getCoupon_money());
                                            transferMoney(parkId, shop,tParkInOut);
                                            //修改商户电子卷数量
                                            updateBusineTicket(tBusineTicket);
                                            //把已存在的改成作废
                                            if (tTicketCouponList.size()>0){
                                                TTicketCoupon tTicketCoupon1 = tTicketCouponList.get(0);
                                                tTicketCoupon1.setIsUse(3);
                                                tTicketCouponMapper.updateByPrimaryKeySelective(tTicketCoupon1);
                                            }
                                        } else {
                                            logger.info("已存在较大优惠，本次优惠不能生效");
                                            throw new ActionRspException(ActionRspEnum.ExistedCoupon_ERROR);
                                        }
                                        logger.info("允许多次代缴取最大,下发金额："+shop.getCoupon_money()+"元。"+msg);
                                        break;
                                    default:
                                        break;
                                }
                            }else {
                            logger.info("余票不足");
                            throw new ActionRspException(ActionRspEnum.InsufficientTicket_ERROR);
                            }
                        } else {
                            msg = "ticketId不合法";
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        if (msg.equals("优惠成功") && tConponQrcode!=null){
            tConponQrcode.setUseLimit(tConponQrcode.getUseLimit()-1);
            tConponQrcodeMapper.updateByPrimaryKeySelective(tConponQrcode);
        }
        return msg;
        }catch (Exception e){
              return "优惠失败";
        }
    }

    @Override
    public String getTBusineTicket(Map mapData) {
        String msg = "";
        TBusineTicketCriteria tBusineTicketCriteria = new TBusineTicketCriteria();
        TBusineTicketCriteria.Criteria criteria = tBusineTicketCriteria.createCriteria();
        if (!StringUtils.isBlank(mapData.get("company_id").toString())) {
            criteria.andCompanyIdEqualTo(Integer.valueOf(mapData.get("company_id").toString()));
        }
        if (!StringUtils.isBlank(mapData.get("busine_id").toString())) {
            criteria.andBusineIdEqualTo(Integer.valueOf(mapData.get("busine_id").toString()));
        }
        if (!StringUtils.isBlank(mapData.get("ticket_id").toString())) {
            criteria.andTicketIdEqualTo(Integer.valueOf(mapData.get("ticket_id").toString()));
        }
        List<TBusineTicket> tBusineTickets = tBusineTicketMapper.selectByExample(tBusineTicketCriteria);
        if (tBusineTickets.size() == 0) {
            msg = "优惠券不存在";
        } else {
            msg = JsonUtil.beanToJson(tBusineTickets.get(0));
        }
        return msg;
    }


    //生成优惠记录
    private void transferBusinesCoupon(Integer parkId,Shop shop,TParkInOut tParkInOut,TBusinesCoupon tBusinesCouponOld){
        if (tBusinesCouponOld == null) {
            TBusine tBusine = tBusineMapper.selectByPrimaryKey(shop.getMerchant_Id());
            TCompanyPark tCompanyPark = tCompanyParkMapper.selectByPrimaryKey(parkId);
            TBusinesCoupon tBusinesCoupon = new TBusinesCoupon();
            tBusinesCoupon.setCouponCode(DateUtil.getCurrenDateANY(DateUtil.sdfDateTimeFormat_II)+parkId);
            tBusinesCoupon.setCreateDate(DateUtil.getCurrenDateANY(DateUtil.sdfDateTimeFormat));
            tBusinesCoupon.setEndDate(StringUtil.newDate(new Date(),15));
            tBusinesCoupon.setParkName(tCompanyPark.getParkName());
            tBusinesCoupon.setCouponPay(shop.getCoupon_money());
            tBusinesCoupon.setInTime(tParkInOut.getInTime());
            tBusinesCoupon.setDisable(0);
            tBusinesCoupon.setCompanyId(tBusine.getCompanyId());
            tBusinesCoupon.setBusineId(tBusine.getId());
            tBusinesCoupon.setCarPlate(tParkInOut.getInCarPlate());
            tBusinesCoupon.setParkId(parkId);
            tBusinesCouponMapper.insert(tBusinesCoupon);
        } else {
            tBusinesCouponOld.setDisable(1);
            tBusinesCouponMapper.updateByPrimaryKeySelective(tBusinesCouponOld);
        }
    }

    //生成电子券使用记录
    private void transferTicketCoupon(BusineCouponUpload busineCouponUpload, TBusine tBusine, TCompany tCompany, TTicketCoupon tTicketCouponRecord, TElectronicTicket electronicTicket){
        TCompanyPark tCompanyPark = tCompanyParkMapper.selectByPrimaryKey(busineCouponUpload.getParkId());
        tTicketCouponRecord.setCouponType(electronicTicket.getTicketType());
        tTicketCouponRecord.setParkId(busineCouponUpload.getParkId());
        tTicketCouponRecord.setCarplate(busineCouponUpload.getCarPlate());
        tTicketCouponRecord.setCouponCode(DateUtil.getCurrenDateANY(DateUtil.sdfDateTimeFormat_II));
        tTicketCouponRecord.setBatchCode(busineCouponUpload.getBusineTicketId());
        tTicketCouponRecord.setBusineId(busineCouponUpload.getBusineId());
        tTicketCouponRecord.setBusineName(tBusine.getBusineName());
        tTicketCouponRecord.setCompanyId(tCompany.getId());
        tTicketCouponRecord.setInTime(busineCouponUpload.getInTime());
        tTicketCouponRecord.setParkName(tCompanyPark.getParkName());
        tTicketCouponRecord.setCouponPay(busineCouponUpload.getCouponPay());
        tTicketCouponRecord.setIsUse(0);
        tTicketCouponRecord.setRemark("未使用。"+(busineCouponUpload.getRemark()==null?"":busineCouponUpload.getRemark()));
        try {
            if (electronicTicket.getPermissionDay().equals("0")){
                tTicketCouponRecord.setPermissionDate("0");
            }else {
                tTicketCouponRecord.setPermissionDate(StringUtil.newDate(DateUtil.parse(DateUtil.getCurDateTime(), DateUtil.sdfDateTimeFormat), Integer.valueOf(electronicTicket.getPermissionDay()) * 24 * 60));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        tTicketCouponRecord.setTicketId(busineCouponUpload.getTicketId());
        tTicketCouponRecord.setTicketName(electronicTicket.getTicketName());
        tTicketCouponRecord.setUpdateTime(DateUtil.getCurDateTime());
        tTicketCouponRecord.setCreateTime(DateUtil.getCurDateTime());
        tTicketCouponMapper.insertSelective(tTicketCouponRecord);
    }
    //修改商户电子券数量
    private void updateBusineTicket(TBusineTicket tBusineTicket){
        tBusineTicket.setTicketNum(tBusineTicket.getTicketNum()-1);
        tBusineTicketMapper.updateByPrimaryKey(tBusineTicket);
    }

    //下发金额
    private void transferMoney(Integer parkId, Shop shop,TParkInOut tParkInOut){
        //TParkInOut tParkInOut = customizeMapper.getRecentParkinout(parkId, shop.getCar_num());
        //生成下达data
        shop.setClient_id(tParkInOut.getClientId());
        shop.setOrderId(tParkInOut.getOrderId());
        //System.out.println("shop"+shop.toString());
        transferTask(parkId,shop);
    }
    //下发金额，非电子券模式
    private String transferMoneyTraditional(Integer parkId, Shop shop,TBusine tBusine,Double couponPayNew,TParkInOut tParkInOut){
        String msg="优惠成功";
        //TParkInOut tParkInOut = customizeMapper.getRecentParkinout(parkId, shop.getCar_num());
        //生成下达data
        shop.setClient_id(tParkInOut.getClientId());
        shop.setOrderId(tParkInOut.getOrderId());
        if (shop.getCoupon_money()==999){
            if (tBusine.getBalance()>0){
                transferTask(parkId,shop);
                //生成优惠记录
                shop.setCoupon_money(0.00);
                transferBusinesCoupon(parkId,shop,tParkInOut,null);

            }else {
                logger.info( "商户余额不足");
                throw new ActionRspException(ActionRspEnum.InsufficientBalance_ERROR);
            }
        } else if (shop.getCoupon_money()==0.00){
            msg = "优惠金额不能为0";
        }else {
            if (couponPayNew==null){
                couponPayNew = shop.getCoupon_money();
            }
            //余额大于下发金额
            if (tBusine.getBalance()>couponPayNew || tBusine.getDiscountType()==4){
                if (tBusine.getDiscountType()!=4){
                    //下发任务
                    transferTask(parkId, shop);
                    //生成优惠记录
                    shop.setCoupon_money(couponPayNew);
                    transferBusinesCoupon(parkId,shop,tParkInOut,null);
                    //修改商户余额
                    tBusine.setBalance(tBusine.getBalance()-couponPayNew);
                    changeBusin(tBusine);
                }else {
                    //生成优惠记录
                    shop.setCoupon_money(couponPayNew);
                    transferBusinesCoupon(parkId,shop,tParkInOut,null);
                    shop.setCar_num(StringUtil.deCode(shop.getCar_num()) );
                    shop.setMerchant_name(StringUtil.deCode(shop.getMerchant_name()));
                    msg = JsonUtil.beanToJson(shop);
                }
            }else {
                logger.info( "商户余额不足");
                throw new ActionRspException(ActionRspEnum.InsufficientBalance_ERROR);
            }
        }
        return msg;
    }


    //1)修改商户余额
    @Transactional(rollbackFor=Exception.class)
    public void changeBusin(TBusine tBusine){
        tBusineMapper.updateByPrimaryKeySelective(tBusine);
    }
    //2）更新parkinout信息
    @Transactional
    public void updateParkInOut(){}
    //3）下发任务
    @Transactional(rollbackFor=Exception.class)
    public void transferTask(Integer parkId,Shop shop){
        /*List<String> outComputerIndex = customizeMapper.selectComputerIndex(parkId,1);
        if (outComputerIndex.size()>0){
        for (String index : outComputerIndex){
            customizeMapper.insetCouponble(parkId,shop,index);
        }
        }*/
        //改用MQTT下发优惠
        mqttBaseService.SendTask(parkId,JsonUtil.beanToJson(shop));
    }

    /**
     * 线下岗亭请求下发会员优惠
     * @param theThirdCoupon
     * @return
     */
    public String SendTheThirdCoupon(TheThirdCoupon theThirdCoupon){
        Integer parkId=Integer.valueOf(theThirdCoupon.getParkId());
        TBusine busine=new TBusine();
        busine.setParkId(parkId);
        busine.setBusineName("会员优惠");
        TBusine sBusine=busineService.getBusine(busine).get(0);
        try{
            Map map=new HashMap();
            map.put("parkId",theThirdCoupon.getParkId());
            map.put("carPlate",StringUtil.chinaToUnicode(theThirdCoupon.getCarPlate()));
            map.put("inTime",theThirdCoupon.getInTime());
            map.put("orderId",theThirdCoupon.getOrderId());
            String params =String.format("params=%s",JsonUtil.mapToJson(map));
            logger.warn("params:参数:"+params);

            logger.warn("请求查询实时优惠信息...");
            String result = HttpUtil.doPost("http://yuntest.bzjf-tech.com:8181/discounts/parkvip/discounts", map);
            //String result = HttpUtil.doPost("http://59.50.95.141:8899/discounts/parkvip/discounts", map);
            logger.warn(result);
            TheThirdCouponResult theThirdCouponResult=JsonUtil.jsonToBean(result,TheThirdCouponResult.class);

            if(theThirdCouponResult.getCode().equals("0")){
                BusineCouponUpload busineCouponUpload=new BusineCouponUpload();
                busineCouponUpload.setBusineId(sBusine.getId());
                busineCouponUpload.setCompanyId(sBusine.getCompanyId());
                busineCouponUpload.setCarPlate(theThirdCoupon.getCarPlate());
                busineCouponUpload.setCouponPay(Double.valueOf(theThirdCouponResult.getDiscountsFee()));
                busineCouponUpload.setCouponType(sBusine.getDiscountType());
                busineCouponUpload.setInTime(theThirdCoupon.getInTime());
                busineCouponUpload.setParkId(parkId);
                busineCouponUpload.setOrderId(theThirdCoupon.getOrderId());
                String msg=transferBusineCoupon(busineCouponUpload);
                //logger.info(msg);
                Shop shop =new Shop();
                shop=JsonUtil.jsonToBean(msg,Shop.class);
                shop.setCar_num(StringUtil.enCode(shop.getCar_num()));
                shop.setMerchant_name(StringUtil.enCode(shop.getMerchant_name()));
                msg=JsonUtil.beanToJson(shop);
                mqttBaseService.SendTask(parkId,msg);

                //领取会员优惠后通知第三方核销
                map.put("parkId",theThirdCoupon.getParkId());
                map.put("carPlate",StringUtil.chinaToUnicode(theThirdCoupon.getCarPlate()));
                map.put("inTime",theThirdCoupon.getInTime());
                map.put("orderId",theThirdCoupon.getOrderId());
                logger.warn("请求核销实时优惠信息...");
                //result = HttpUtil.doPost("http://120.55.156.126:9808/discounts/parkvip/employ", map);
                result = HttpUtil.doPost("http://yuntest.bzjf-tech.com:8181/discounts/parkvip/employ", map);

                logger.info(result);
            }
            else{
                SendZeroCoupon(theThirdCoupon,sBusine,parkId);
            }
        }
        catch (Exception e){
            SendZeroCoupon(theThirdCoupon,sBusine,parkId);
        }

        return "下发会员优惠成功";
    }
    public void SendZeroCoupon(TheThirdCoupon theThirdCoupon, TBusine sBusine,Integer parkId){

        Integer carPlateLen = theThirdCoupon.getCarPlate().length();
        TParkInOut tParkInOut = customizeMapper.getRecentParkinout(parkId, theThirdCoupon.getCarPlate().substring(1,carPlateLen),theThirdCoupon.getInTime());
        TBusinesCoupon tBusinesCouponJudge = new TBusinesCoupon();
        tBusinesCouponJudge.setCarPlate(theThirdCoupon.getCarPlate());
        tBusinesCouponJudge.setInTime(theThirdCoupon.getInTime());
        tBusinesCouponJudge.setParkId(parkId);
        List<TBusinesCoupon> tBusinesCouponList = tBusinesCouponMapper.selectByExample(getTBusinesCouponCriteria(tBusinesCouponJudge));
        Double CouponFee=0.0;
        if(tBusinesCouponList!=null&&tBusinesCouponList.size()>0){
            for(TBusinesCoupon tBusinesCoupon:tBusinesCouponList){
                CouponFee+=tBusinesCoupon.getCouponPay();
            }
        }
        Shop shop =new Shop();
        shop.setCoupon_money(CouponFee);
        shop.setCar_num(StringUtil.enCode(theThirdCoupon.getCarPlate()));
        shop.setMerchant_Id(sBusine.getId());
        shop.setMerchant_name(StringUtil.enCode(sBusine.getBusineName()));
        shop.setDiscount_time(DateUtil.getCurDateTime());
        shop.setOrderId(theThirdCoupon.getOrderId());
        shop.setClient_id(tParkInOut.getClientId());
        shop.setPaymode(CommonUtil.OUT_TYPE_7);
        shop.setCoupon_type(sBusine.getDiscountType());
        String msg=JsonUtil.beanToJson(shop);
        mqttBaseService.SendTask(parkId,msg);
    }

    /**
     * 推送优惠任务
     * @param parkId
     * @return
     */
    public String SendCoupon(Integer parkId){
        Integer sussessNum=0;
        String result="";
        List<Map<String,String>> Couponlist=customizeMapper.selectCouponble(parkId);
        if(Couponlist.size()>0){
            for (Map<String,String> map:Couponlist){
                mqttBaseService.SendTask(parkId,map.get("data"));
                sussessNum++;
                customizeMapper.DeleteCouponble(parkId,map.get("task_id"));
            }
        }
        result="已成功发送"+sussessNum+"条优惠任务";
        return result;
    }

    /**
     *  武汉预缴请求下发会员优惠
     * @param prePayCoupon
     * @return
     */
    public String SendPrePayCoupon(PrePayCoupon prePayCoupon){
        logger.info(prePayCoupon.toString());
        Integer parkId=Integer.valueOf(prePayCoupon.getParkId());
        TBusine busine=new TBusine();
        busine.setParkId(parkId);
        busine.setBusineName("会员优惠");
        TBusine sBusine=null;
        List<TBusine> tBusines=busineService.getBusine(busine);
        if(tBusines.size()!=0){
            sBusine=tBusines.get(0);
        }
        else
        {
            //新增会员优惠车场不存在会员优惠商户-添加
            TCompanyPark tCompanyPark=new TCompanyPark();
            tCompanyPark=companyParkService.selectByPrimaryKey(parkId);
            busine=new TBusine();
            busine.setCompanyId(tCompanyPark.getCompanyId());
            busine.setParkId(parkId);
            busine.setBusineName("会员优惠");
            busine.setAccount("hyyh"+parkId);
            busine.setPassword("e10adc3949ba59abbe56e057f20f883e");
            busine.setBalance(0.0);
            busine.setBusineType(0);
            busine.setPrincipal("1");
            busine.setPhone("1");
            busine.setMobile("1");
            busine.setAddress("默认地址");
            busine.setBusineStatus(1);
            busine.setIsfree(1);
            busine.setDiscountAmount(999);
            busine.setDiscountType(4);
            busine.setFixedAmount(0.0);
            busine.setInitialAmount(0.0);
            busine.setIsAuto(0);
            busineService.UpdateBusine(busine);
            busine=new TBusine();
            busine.setParkId(parkId);
            busine.setBusineName("会员优惠");
            tBusines=busineService.getBusine(busine);
            if(tBusines.size()!=0){
                sBusine=tBusines.get(0);
            }
        }

        BusineCouponUpload busineCouponUpload=new BusineCouponUpload();
        busineCouponUpload.setBusineId(sBusine.getId());
        busineCouponUpload.setCompanyId(sBusine.getCompanyId());
        busineCouponUpload.setCarPlate(prePayCoupon.getCarPlate());
        busineCouponUpload.setCouponPay(Double.valueOf(prePayCoupon.getDiscountsFee()));
        busineCouponUpload.setCouponType(sBusine.getDiscountType());
        busineCouponUpload.setInTime(prePayCoupon.getInTime());
        busineCouponUpload.setParkId(parkId);
        busineCouponUpload.setOrderId(prePayCoupon.getOrderId());
        String msg=transferBusineCoupon(busineCouponUpload);
        //logger.info(msg);
        Shop shop =new Shop();
        shop=JsonUtil.jsonToBean(msg,Shop.class);
        shop.setCar_num(StringUtil.enCode(shop.getCar_num()));
        shop.setMerchant_name(StringUtil.enCode(shop.getMerchant_name()));
        msg=JsonUtil.beanToJson(shop);
        mqttBaseService.SendTask(parkId,msg);
        return "下发预缴优惠成功";
    }

/*
时间转换成金额
 */
    private Double getTempCarChargeInfo(Integer parkId,String carPlate,Double min,TParkInOut tParkInOut){
        //TParkInOut tParkInOut = customizeMapper.getRecentParkinout(parkId,carPlate);
        String outTime=null;
        try {
             outTime = StringUtil.newDate(DateUtil.parse(tParkInOut.getInTime(),DateUtil.sdfDateTimeFormat),min.intValue());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Double fee=null;
        String key = MD5Util.MD5Encode("BDmlp48liikpom9hj7eczwj7aduGh7io" + StringUtil3.monthHOUR(-1));
        Map map=new HashMap();
        map.put("parkId","["+parkId+"]");
        map.put("carPlate",StringUtil.chinaToUnicode(carPlate));
        map.put("key",key);
        map.put("ID","001");
        map.put("outTime",outTime);
        String params =String.format("params=%s",JsonUtil.mapToJson(map));
        String result = HttpUtil.doPostJson("http://yun.eparking.top:8080/eparking/GZBDws_interface/getTempCarChargeInfo", params);
        ResultEparking resultEparking = JsonUtil.jsonToBean(result, com.api.entity.ResultEparking.class);
        if (resultEparking.getCode()==1){
            List<FreeResult> list = resultEparking.getFeeResults();
            if (list.size()==1){
                fee = list.get(0).getFee();
            }
        }
        return fee;
    }

    public TBusinesCouponCriteria getTBusinesCouponCriteria(TBusinesCoupon tBusinesCoupon){
        TBusinesCouponCriteria tBusinesCouponCriteria = new TBusinesCouponCriteria();
        TBusinesCouponCriteria.Criteria criteria = tBusinesCouponCriteria.createCriteria();
        if (tBusinesCoupon.getInTime()!=null){
            criteria.andInTimeEqualTo(tBusinesCoupon.getInTime());
        }if (tBusinesCoupon.getCarPlate()!=null){
            criteria.andCarPlateEqualTo(tBusinesCoupon.getCarPlate());
        }if (tBusinesCoupon.getDisable()!=null){
            criteria.andDisableEqualTo(tBusinesCoupon.getDisable());
        }if (tBusinesCoupon.getParkId()!=null){
            criteria.andParkIdEqualTo(tBusinesCoupon.getParkId());
        }
        return tBusinesCouponCriteria;

    }
    public TBusineTicketCriteria getTBusineTicketCriteria(TBusineTicket tBusineTicket){
        TBusineTicketCriteria tBusineTicketCriteria = new TBusineTicketCriteria();
        TBusineTicketCriteria.Criteria criteria = tBusineTicketCriteria.createCriteria();
        if (tBusineTicket.getBusineId()!=null){
            criteria.andBusineIdEqualTo(tBusineTicket.getBusineId());
        }if (tBusineTicket.getTicketId()!=null){
            criteria.andTicketIdEqualTo(tBusineTicket.getTicketId());
        }
        return tBusineTicketCriteria;
    }
    private TTicketCouponCriteria getTTicketCouponCriteria(TTicketCoupon tTicketCoupon){
        TTicketCouponCriteria tTicketCouponCriteria = new TTicketCouponCriteria();
        TTicketCouponCriteria.Criteria criteria = tTicketCouponCriteria.createCriteria();
        /*List<Integer> list = Arrays.asList(0,1,2);
        criteria.andIsUseIn(list);*/
        if (tTicketCoupon.getCarplate()!=null){
            criteria.andCarplateEqualTo(tTicketCoupon.getCarplate());
        }if (tTicketCoupon.getParkId()!=null){
            criteria.andParkIdEqualTo(tTicketCoupon.getParkId());
        }if (tTicketCoupon.getInTime()!=null){
            criteria.andInTimeEqualTo(tTicketCoupon.getInTime());
        }
        return tTicketCouponCriteria;
    }

    public static void main(String[] args) {
        /*Double fee=null;
        String key = MD5Util.MD5Encode("BDmlp48liikpom9hj7eczwj7aduGh7io" + StringUtil3.monthHOUR(-1));
        Map map=new HashMap();
        map.put("parkId","["+274+"]");
        map.put("carPlate",StringUtil.chinaToUnicode("粤CS1800"));
        map.put("key",key);
        map.put("ID","001");
        map.put("outTime","2018-12-07 15:29:38");
        String params =String.format("params=%s",JsonUtil.mapToJson(map));
        String result = HttpUtil.doPostJson("http://yun.eparking.top:8080/eparking/GZBDws_interface/getTempCarChargeInfo", params);
        ResultEparking resultEparking = JsonUtil.jsonToBean(result, com.api.entity.ResultEparking.class);
        if (resultEparking.getCode()==1){
            List<FreeResult> list = resultEparking.getFeeResults();
            if (list.size()==1){
                fee = list.get(0).getFee();
            }
        }
        System.out.println(fee);*/
        //非电子卷例子
        /*Map map=new HashMap();
        map.put("service","TRPolicePark");
        map.put("ID","005");
        map.put("key",MD5Util.MD5Encode("ce307b7211526d06952875cc9619ea13" + StringUtil3.monthHOUR(-1)));
        map.put("parkId","000");
        map.put("data","{\"startDateTime\":\"2019-11-07 10:29:38\",\"endDateTime\":\"2018-12-07 10:29:38\",\"page\":\"1\",\"rows\":\"200\",\"gg_ssjgbm_1\":\"B26306\"}");
        String result = HttpUtil.doPost("http://yun1.eparking.top/GZBZTheThirdAPI/mainAction",map);
        System.out.println(result);
        ActionRsp actionRsp = JsonUtil.jsonToBean(result,ActionRsp.class);*/

        /*CloudData cloudData = new CloudData();
        cloudData.setParkingId("274");
        cloudData.setOrderId("274120181207104728126");
        cloudData.setParkId("274");
        cloudData.setSettleDate("01");
        cloudData.setBillNo("01");*/
        System.out.println(DateUtil.getCurrenDateANY(DateUtil.sdfDateTimeFormat_II)+274);
    }

}
