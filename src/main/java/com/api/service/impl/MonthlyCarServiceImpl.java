package com.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.api.dao.*;
import com.api.entity.*;
import com.api.service.CarPayRuleService;
import com.api.service.MonthlyCarService;
import com.api.util.*;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*import com.alibaba.fastjson.JSONObject;
import net.sf.json.JSONObject;*/

/**
 * @ClassName MonthlyCarServiceImpl
 * @Author jin
 * @Date 2018/9/21 13:20
 **/
@Service
public class MonthlyCarServiceImpl implements MonthlyCarService {
    private  static final Logger logger= LoggerFactory.getLogger(MonthlyCarServiceImpl.class);
    @Autowired
    private TParkCarMapper tParkCarMapper;
    @Autowired
    private CustomizeMapper customizeMapper;
    @Autowired
    private CarPayRuleService carPayRuleService;
    @Autowired
    private TCarPaymentMapper tCarPaymentMapper;
    @Autowired
    private TCarPayRuleMapper tCarPayRuleMapper;
    @Autowired
    private TParkPortMapper tParkPortMapper;

    /**
     * 设置查询条件
     * @param tParkCar
     * @return
     */
    private TParkCarCriteria setCriteria(TParkCar tParkCar){
        TParkCarCriteria tParkCarCriteria = new TParkCarCriteria();
        if (tParkCar!=null){
            TParkCarCriteria.Criteria criteria = tParkCarCriteria.createCriteria();
            if(tParkCar.getParkId()!=null){
                criteria.andParkIdEqualTo(tParkCar.getParkId());
            }
            if (tParkCar.getStatus()!=null){
                criteria.andStatusEqualTo(tParkCar.getStatus());
            }
            if (tParkCar.getParkingSpace()!=null){
                criteria.andParkingSpaceEqualTo(tParkCar.getParkingSpace());
            }
            if (tParkCar.getPayRule()!=null){
                criteria.andPayRuleEqualTo(tParkCar.getPayRule());
            }
            if (tParkCar.getCarSeat()!=null && tParkCar.getCarSeat().length()>0){
                criteria.andCarSeatLike("%"+tParkCar.getCarSeat()+"%");
            }
            if (tParkCar.getCarPlate()!=null && tParkCar.getCarPlate().length()>0){
                criteria.andCarPlateLike("%"+tParkCar.getCarPlate()+"%");
            }
            if (tParkCar.getStopTime()!=null && tParkCar.getStopTime().length()>0 && tParkCar.getLockTime()!=null && tParkCar.getLockTime().length()>0){
                criteria.andStopTimeBetween(tParkCar.getStopTime(),tParkCar.getLockTime());
            }if (tParkCar.getStopTime()!=null && tParkCar.getStopTime().length()>0 && (tParkCar.getLockTime()==null || tParkCar.getLockTime().length()==0)){
                criteria.andStopTimeGreaterThanOrEqualTo(tParkCar.getStopTime());
            }if ((tParkCar.getStopTime()==null || tParkCar.getStopTime().length()==0) && tParkCar.getLockTime()!=null && tParkCar.getLockTime().length()>0){
                criteria.andStopTimeLessThanOrEqualTo(tParkCar.getLockTime());
            }
            if (tParkCar.getEndDate()!=null){
                criteria.andEndDateGreaterThanOrEqualTo(tParkCar.getEndDate());
            }
        }
        return  tParkCarCriteria;
    }
    /**
     * 获取数据总量
     * @param tParkCar
     * @return
     */
    private Integer getCount(TParkCar tParkCar){
        Integer total =(int)tParkCarMapper.countByExample(setCriteria(tParkCar));
        return total;
    }
    /**
     *获取月租车信息(分页)
     * @param tParkCar
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageBean<TParkCar> getTParkCarlistbyPage(TParkCar tParkCar, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TParkCar> tParkCarList=getTParkCarlist(tParkCar);
        Integer countNums =getCount(tParkCar);
        PageBean<TParkCar> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tParkCarList);
        return pageData;
    }
    /**
     * 获取月租车信息
     * @param tParkCar
     * @return
     */
    @Override
    public List<TParkCar> getTParkCarlist(TParkCar tParkCar) {
        List<TParkCar> tParkCarList = tParkCarMapper.selectByExample(setCriteria(tParkCar));
        return tParkCarList;
    }

    /**
     * 查询框体中的数量
     * @return
     */
    @Override
    public TCustomize getCarNum(String parkid) {
        TCustomize tCustomize = customizeMapper.selectMonthlyNum(parkid);
        return tCustomize;
    }

    @Override
    public TParkCar UpdateTParkCar(TParkCar tParkCar) {
        TParkCarCriteria tParkCarCriteria = new TParkCarCriteria();
        TParkCarCriteria.Criteria criteria = tParkCarCriteria.createCriteria();
        String msg;
        if (tParkCar.getId()!=null){
            TParkCar tParkCarPar = tParkCarMapper.selectByPrimaryKey(tParkCar.getId());
            //修改了状态值
            if (!tParkCarPar.getStatus().equals(tParkCar.getStatus())){
                //状态值发生变化，并且改变值为暂停
                if (tParkCar.getStatus()==2){
                    tParkCar.setStopTime(DateUtil.getCurDateTime());
                }
                //状态值发生变化，并且改变值为启用
                if (tParkCar.getStatus()==1){
                    //修改月租截止日期加上暂停的天数
                    Integer days = DateUtil.nowBetweenStartTime(tParkCarPar.getStopTime());
                    String endData = DateUtil.changeDate(DateUtil.getStartDateInterval(tParkCarPar.getEndDate(),days*24*60));
                    tParkCar.setEndDate(endData);
                }}
           tParkCarMapper.updateByPrimaryKey(tParkCar);
        }else{
            //目前member无用，默认值给0
            tParkCar.setMemberId(0);
            //新增月租车，默认起止时间为当前，截止时间为前一天
            tParkCar.setBeginDate(DateUtil.getCurDateYMR());
            tParkCar.setEndDate(DateUtil.getPredate());
            tParkCarMapper.insert(tParkCar);
        }
        TParkCar tParkCarNew=getTParkCarlist(tParkCar).get(0);
        //编辑或新增后下发任务
        syncParkCarTask(tParkCarNew);
       return tParkCarNew;
    }



    @Override
    public List<TParkCar> getCloseParkCar(String closeType, String payRule, String parkid) {

        return customizeMapper.selectCloseParkCar(closeType,payRule,parkid);
    }
    @Override
    public JSONObject getNeedPay(Integer payStandard, Integer payCount, TParkCar tParkCar) {
        Double needPay = 0.0;//应收费
        String endDate = null;//截止日期
        JSONObject lan=new JSONObject();
        try {
            TCarPayRule carPayRule = carPayRuleService.getCarPayRuleByid(tParkCar.getPayRule());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date bigengDate = sdf.parse(tParkCar.getEndDate());


            Integer parkingNo = tParkCar.getParkingNo();
            if (carPayRule != null) {
                //年缴
                if (CommonUtil.CAR_PAY_RULE_TYPE_Y.equals(payStandard)) {
                    needPay = parkingNo * payCount * carPayRule.getYearFee();
                    endDate = sdf.format(StringUtil3.getBeforeDay(bigengDate, 365 * payCount));
                    //季度
                } else if (CommonUtil.CAR_PAY_RULE_TYPE_Q.equals(payStandard)) {
                    Long needPay1 = (parkingNo * payCount * carPayRule.getSeasonFee());
                    needPay = needPay1.doubleValue();
                    endDate = sdf.format(StringUtil3.getBeforeMonth(bigengDate, 3 * payCount));
                } else if (CommonUtil.CAR_PAY_RULE_TYPE_M.equals(payStandard)) {
                    needPay = parkingNo * payCount * carPayRule.getMonthFee();
                    endDate = sdf.format(StringUtil3.getBeforeMonth(bigengDate, payCount));
                } else if (CommonUtil.CAR_PAY_RULE_TYPE_D.equals(payStandard)) {
                    needPay = parkingNo * payCount * carPayRule.getDayFee();
                    endDate = sdf.format(StringUtil3.getBeforeDay(bigengDate, payCount));
                }
            }
        } catch (Exception e) {
        e.printStackTrace();
    }
        //result = "{\"result\":\"success\",\"needPay\":\"" + needPay + "\",\"endDate\":\"" + endDate + "\"}";
        /*lan.addProperty("id",tParkCar.getId());
        lan.addProperty("needPay",needPay);
        lan.addProperty("endDate",endDate);*/
        lan.put("id",tParkCar.getId());
        lan.put("needPay",needPay);
        lan.put("endDate",endDate);
        return lan;
    }

    @Override
    public TParkCar getParkCar(Integer id) {
        return tParkCarMapper.selectByPrimaryKey(id);
    }

    @Override
    public String Resetport(String portids, String ids) {
        customizeMapper.Resetport(portids,ids);
        return "修改成功";
    }

    @Override
    public Integer getMaturityNo(String parkid) {
        return customizeMapper.getMaturityNo(parkid);
    }





    /*根据主键id获取实体*/
    @Override
    public TParkCar getTParkCarById(Integer id) {
        return tParkCarMapper.selectByPrimaryKey(id);
    }

    /*月租车冲正*/
    @Override
    public String correct(TParkCar parkCar, TCarPayment carPayment) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newTime = sdf.format(new Date());
        //获取父停车场信息
        boolean istaks = false;
        TParkCar parentParkCar = tParkCarMapper.selectByPrimaryKey(parkCar.getId());
        if(!parkCar.getEndDate().trim().equals(parentParkCar.getEndDate().trim()))
        {
            istaks = true;
            parentParkCar.setIsSync((short)0);//未同步
        }
        parentParkCar.setEndDate(parkCar.getEndDate());
        parentParkCar.setBeginDate(parkCar.getBeginDate());
        carPayment.setCarplate(parentParkCar.getCarPlate());
        carPayment.setOperType(CommonUtil.OPER_TYPE_2); //充正
        carPayment.setMemberId(parentParkCar.getMemberId());
        carPayment.setParkId(parentParkCar.getParkId());
        carPayment.setPayTime(newTime);
        carPayment.setActualPay(carPayment.getNeedPay()*-1);
        carPayment.setNeedPay(carPayment.getNeedPay()*-1);
        carPayment.setCompanyId(parentParkCar.getCompanyId());
        carPayment.setBeginDate(parentParkCar.getBeginDate());
        tCarPaymentMapper.insert(carPayment);
        tParkCarMapper.updateByPrimaryKey(parentParkCar);
        if(istaks)
        {			//同步数据
            syncParkCarTask(parentParkCar);
        }
        return "成功冲正";
    }
    /*删除*/
    @Override
    public String refund(TParkCar parkCar, TCarPayment carPayment, String isRefund) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newTime = sdf.format(new Date());
        //获取父停车场信息
        TParkCar parentParkCar = tParkCarMapper.selectByPrimaryKey(parkCar.getId());
        parentParkCar.setIsSync(CommonUtil.STATUS_NO.shortValue());//未同步
        parentParkCar.setEndDate(sdf.format(StringUtil3.getBeforeDay(new Date(),-1))); //过期时间为昨天
        parentParkCar.setIsDelet(CommonUtil.STATUS_YES.shortValue()); //删除状态
        if("1".equals(isRefund))
        {
            carPayment.setCarplate(parentParkCar.getCarPlate());
            carPayment.setOperType(CommonUtil.OPER_TYPE_3); //退款
            carPayment.setMemberId(parentParkCar.getMemberId());
            carPayment.setParkId(parentParkCar.getParkId());
            carPayment.setEndDate(sdf.format(StringUtil3.getBeforeDay(new Date(),-1))); //过期时间为昨天
            carPayment.setPayTime(newTime);
            carPayment.setActualPay(carPayment.getNeedPay()*-1);
            carPayment.setNeedPay(carPayment.getNeedPay()*-1);
            carPayment.setCompanyId(parentParkCar.getCompanyId());
            tCarPaymentMapper.insert(carPayment);
        }
        tParkCarMapper.deleteByPrimaryKey(parentParkCar.getId());
        //parkCarDao.update(parentParkCar);
        //数据同步
        syncParkCarTask(parentParkCar);
        return "删除成功";
    }

    @Override
    public String recharge(TCarPayment carPayment, TParkCar parkCar) {
        String error = null;
        try{
            SimpleDateFormat sdf_ss = new SimpleDateFormat("yyyy-MM-dd");
            //criteria.andIdEqualTo(parkCar.getId());
            TParkCar parentParkCar = parkCar;
            //if(StringUtil3.isNull(parkCar.getBeginDate()))
                //throw new ServiceException("请填写起始时间");
                //if(StringUtil3.isNull(parkCar.getEndDate()))
                    //throw new ServiceException("请填写过期时间");
                    //月租车过期
                    if(sdf_ss.parse(parentParkCar.getEndDate()).getTime()<sdf_ss.parse(StringUtil3.newTime).getTime()) {
                        //续费日期大于原截至日期
                        if( sdf_ss.parse(parentParkCar.getEndDate()).getTime()<sdf_ss.parse(parkCar.getBeginDate()).getTime()) {
                            parentParkCar.setBeginDate(parkCar.getBeginDate());
                        }
                    }
            parentParkCar.setEndDate(carPayment.getEndDate());
            parentParkCar.setIsSync((short)0);
            carPayment.setCarplate(parentParkCar.getCarPlate());
            carPayment.setOperType(1); //充值
            carPayment.setMemberId(parentParkCar.getMemberId());
            carPayment.setParkId(parentParkCar.getParkId());
            carPayment.setPayTime(sdf_ss.format(new Date()));
            carPayment.setCompanyId(parentParkCar.getCompanyId());
            carPayment.setPayType((short)1);
            carPayment.setBeginDate(parentParkCar.getBeginDate());
            if (parentParkCar.getIsOwner() == null){
                if(parentParkCar.getParkCode() == null || parentParkCar.getParkCode().equals("")){//1=独占车位2=公用车位，此值根据是否有车位编码确定
                    parentParkCar.setIsOwner((short)2);}
                else{
                    parentParkCar.setIsOwner((short)1);}
            }
            tCarPaymentMapper.insert(carPayment);
            tParkCarMapper.updateByPrimaryKey(parentParkCar);
            error = "success";
            parentParkCar.setEndDate(carPayment.getEndDate());
            //同步数据
            TMember member = new TMember();
            //syncMember(parentParkCar);
        }catch(Exception e){
            e.printStackTrace();
            error = e.getMessage();
            throw new RuntimeException(e.getMessage());
        }
        return error;
    }

    @Override
    public List<TParkCar> whetherParkCar(Integer parkId, String carPlate) {
        TParkCar tParkCar = new TParkCar();
        tParkCar.setParkId(parkId);
        tParkCar.setCarPlate(carPlate);
        tParkCar.setEndDate(DateUtil.getCurDateTime());
        return tParkCarMapper.selectByExample(setCriteria(tParkCar));
    }


    /**
     * 用于月租车下发任务
     * @param parkCar
     */
    public synchronized void syncParkCarTask(TParkCar parkCar){
        ParkCarTask parkCarTask = new ParkCarTask();
        parkCarTask.setAddress(StringUtil.enCode(parkCar.getAddress()));
        parkCarTask.setBindingName(StringUtil.enCode(parkCar.getBindingName()));
        parkCarTask.setCar_plate(StringUtil.enCode(parkCar.getCarPlate()));
        parkCarTask.setCar_type(parkCar.getCarType());
        parkCarTask.setCloud_park_car_id(parkCar.getId());
        parkCarTask.setIsActivate(CommonUtil.MEMBER_LIVE_STATUS_2);
        parkCarTask.setIsOwner(Integer.valueOf(parkCar.getIsOwner()));
        parkCarTask.setIsUse(parkCar.getIsUse());
        parkCarTask.setLane_rights(parkCar.getPortId());
        parkCarTask.setMcard_begin_date(parkCar.getBeginDate());
        parkCarTask.setMcard_end_date(parkCar.getEndDate());
        parkCarTask.setMcard_status(parkCar.getStatus() == null ? 1 : Integer.valueOf(parkCar.getStatus()));
        parkCarTask.setMember_id(parkCar.getId());
        parkCarTask.setParkingNo(parkCar.getParkingNo());
        parkCarTask.setParkCode(parkCar.getParkCode());
        parkCarTask.setParkingSpace(parkCar.getParkingSpace());
        parkCarTask.setPhone(parkCar.getPhone());
        parkCarTask.setRealname(StringUtil.enCode(parkCar.getRealname()));
        parkCarTask.setRuleName(StringUtil.enCode(parkCar.getPayruleidstr()));
        parkCarTask.setP_card_id("");
        parkCarTask.setP_card_code("");
        //删除下发任务时，云端直接删除数据库信息，实体类isdelet改成1,传入
        if(parkCar.getIsDelet()==1){parkCarTask.setDelete("true");}
        else{parkCarTask.setDelete("false");}
        //填入月租车每日有效时间
        TCarPayRule tCarPayRule = tCarPayRuleMapper.selectByPrimaryKey(parkCar.getPayRule());
        parkCarTask.setDailyStartTime(tCarPayRule.getDailyStartTime());
        parkCarTask.setDailyEndTime(tCarPayRule.getDailyEndTime());
        TParkPortCriteria tParkPortCriteria = new TParkPortCriteria();
        TParkPortCriteria.Criteria criteria = tParkPortCriteria.createCriteria();
        criteria.andParkIdEqualTo(parkCar.getParkId());
        //查找该停车场所有的出场电脑
        criteria.andPortTypeEqualTo(1);
        List<TParkPort> tParkPortList = tParkPortMapper.selectByExample(tParkPortCriteria);
        for (TParkPort tParkPort : tParkPortList){
        customizeMapper.insetParktable(parkCar.getParkId(),parkCar.getId(),parkCarTask,tParkPort.getComputerIndex());
        }
    }

}
