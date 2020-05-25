package com.api.dao;

import com.api.dao.sqlProvider.CustomizeSqlProvider;
import com.api.entity.*;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;
import java.util.Map;

public interface CustomizeMapper {

    @SelectProvider(type=CustomizeSqlProvider.class, method="selectMonthlyNum")
    TCustomize selectMonthlyNum(String parkId);
    @SelectProvider(type=CustomizeSqlProvider.class, method="parkTiggerForTask")
    void  parkTiggerForTask(String parkId);
    @SelectProvider(type=CustomizeSqlProvider.class, method="parkTiggerForInOut")
    void  parkTiggerForInOut(String parkId);
    @SelectProvider(type=CustomizeSqlProvider.class, method="selectMainNum")
    TCustomize selectMainNum(String parkId);

    @SelectProvider(type=CustomizeSqlProvider.class, method="selectHistogram")
    List<Histogram> selectHistogram(String parkId, String year, String type);

    @SelectProvider(type=CustomizeSqlProvider.class, method="selectCompanyPark")
    Map selectCompanyPark(String parkId);

    @UpdateProvider(type=CustomizeSqlProvider.class, method="updateCompanyPark")
    int updateCompanyPark(String parkId, String column, Integer msg);
    @InsertProvider(type=CustomizeSqlProvider.class, method="paymentForDay")
    int paymentForDay();
    @SelectProvider(type=CustomizeSqlProvider.class, method="findParkPortInId")
    List<TParkPort> findParkPortInId(String ids);

    @InsertProvider(type=CustomizeSqlProvider.class, method="insetParktable")
    int insetParktable(Integer parkId, Integer parkCarId, ParkCarTask parkCarTask, String computerIndex);

    /**
     * 查停车记录今日缴费分类别
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="selectParkingRecordNum")
    Map selectParkingRecordNum(String parkid);
    /**
     * 查询快到期的月租车
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="selectCloseParkCar")
    List<TParkCar> selectCloseParkCar(String closeDays, String payRule, String parkid);
    /**
     * 批量修改通道权限
     */
    @UpdateProvider(type=CustomizeSqlProvider.class, method="Resetport")
    int Resetport(String portids, String ids);
    /**
     * 月底前到期数量
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getMaturityNo")
    int getMaturityNo(String parkid);

    /**
     * 今日车流量
     * @param parkid
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="selectTotalNum")
    int selectTotalNum(String parkid);
    /**
     * 今日分类别类别缴费
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="selectPayByType")
    Map selectPayByType(String parkid);
    /**
     *近七日车流量
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="selectSevenDays")
    List<Map> selectSevenDays(String parkid);
    /**
     * 查看分类型缴费的次数（微信、支付宝、银联、现金）
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="selectePayType")
    Map selectePayType(String parkid);
    /**
     * 总车位，剩余车位
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="selectCarNum")
    Map selectCarNum(String parkid);

    /**
     * 查询首页大部分数据
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="selectMainAllNum")
    Map selectMainAllNum(String parkid);

    /**
     * 查询在场车辆打印内容
     * @param parkid
     * @return
     */
//    @SelectProvider(type=CustomizeSqlProvider.class, method="selectExportPresentCar")
//    Map selectExportPresentCar(String parkid);



    /**
     * 当班对账和电子对账查看详情数目
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="selectDetailNum")
    Integer selectDetailNum(String parkId, String whereType);

    /**
    * 模糊搜索 月租车
    */
    /*@SelectProvider(type=CustomizeSqlProvider.class, method="fuzzyParkCar")
    List<TParkCar> fuzzyParkCar(String key);*/



    /**
     * 搜索在场车辆总数
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="selectPresentCar")
    Integer selectPresentCarNum(String type, String parkId, String andSql);

    /**
     * t_apikey 根据id查实体
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="selectApikey")
    TApikey selectApikey(String ID);

    /**
     * 微信优惠下发任务
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="insetCouponble")
    Integer insetCouponble(Integer parkId, Shop shop, String computerIndex);

    /**
     * 查询优惠下发任务
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="selectCouponble")
    List<Map<String,String>> selectCouponble(Integer parkId);

    /**
     * 删除优惠下发任务
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="DeleteCouponble")
    Integer DeleteCouponble(Integer parkId, String taskId);
    /**
     * 查找电脑脚标
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="selectComputerIndex")
    List<String> selectComputerIndex(Integer parkId, Integer portType);

    /**
     * 当日银联支付订单总额
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getAllUnionPayFeeToday")
    Double getAllUnionPayFeeToday(String andSql, String province);

    /**
     * 当日贵州进出场车辆数
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getInAndOutVehiclesNums")
    Map<String,Integer> getInAndOutVehiclesNums(String andSql);

    /**
     * 历史贵州进出场车辆数
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getInAndOutVehiclesNumsAll")
    Map<String,Integer> getInAndOutVehiclesNumsAll(String andSql, String province);

    /**
     * 近5秒产生的流水中的前五条
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getParkInOut")
    List<TParkInOut> getParkInOut(String time, String andSql, String province);

    /**
     * 近5秒产生的流水数
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getParkInOutNum")
    Integer getParkInOutNum(String time, String andSql, String province);

    /**
     * 今日总交易金额和银联交易金额
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getUnionPayAndTotal")
    Map<String,Double> getUnionPayAndTotal(String andSql, String province);


    /**
     * 各银联支付类型笔数
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getUnionPayTypeNums")
    Map<String,Integer> getUnionPayTypeNums(String andSql, String province);

    /**
     * 查询空余车位数
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getFreeParkingSpace")
    Integer getFreeParkingSpace(String andSql, String province);

    /**
     * 查询周转率
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getParkingTurnover")
    Double getParkingTurnover(String andSql, String province);

    /**
     * 查询周转率
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getParkingUsageRate")
    Double getParkingUsageRate(String andSql, String province);

    /**
     * 查询7天周转率
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getWeekTurnoverTrend")
    List<Map<String,String>> getWeekTurnoverTrend(String andSql);

    /**
     * 贵州车场数：当前贵州车场数量
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="parkCount")
    Integer parkCount(String province);
    /**
     * 贵州车位总数：当前车位总数。
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="parkSpacesSum")
    Integer parkSpacesSum(String province);
    /**
     * 贵州车辆总流量：当前进出车辆总数
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="outboundFlowSum")
    Integer outboundFlowSum(String province);
    /**
     * 年交易总额目标
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="yearsOfTrading")
    Map<String,Integer> yearsOfTrading(String province);
    /**
     *前一周所有车场周转率
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="rotationRateOfPark")
    List<Map<String,Integer>> rotationRateOfPark(String province);

    /**
     *前一周所有车场周转率
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getCoordinate")
    List<Map> getCoordinate(String province);

    /**
     * 查找最新的进场记录
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getRecentParkinout")
    TParkInOut getRecentParkinout(Integer parkId, String inCarPlate, String inTime);

    /**
     * 根据范围查询电子券使用数量
     * @return
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getTicketCouponIsUseNum")
    Integer getTicketCouponIsUseNum(Integer batchCode);

    /**
     * 查询商户最接近过期的电子劵
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getTBusineTicketExpireSoon")
    Integer getTBusineTicketExpireSoon(BusineCouponGetTicketInfo busineCouponGetTicketInfo);

    /**
     * 根据车场id，车牌，进场时间，出场时间，查到唯一一条流水
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="updateBillingStatusByParkIdCarplateInOuttime")
    Integer updateBillingStatusByParkIdCarplateInOuttime (TParkInOut tParkInOut);

    /**
     * 根据停车场id获取交警平台需要的数据
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getGovParkInOut")
    List<GovParkInOut> getGovParkInOut(Integer parkId);

    /**
     * 根据停车场id和id修改上传标识字段
     */
    @UpdateProvider(type=CustomizeSqlProvider.class, method="updateGovUpFlag")
    int updateGovUpFlag(Integer parkId, String field, String ids);

    /**
     * 根据停车场id和orderid获取实体
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getParkinoutByOrderId")
    TParkInOut getParkinoutByOrderId(Integer parkId, String orderId);

    /**
     * 铜仁公安根据条件搜索
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getTRParkInOut")
    List<TParkInOut> getTRParkInOut(Integer parkId, String beginDate, String endDate, String limit);

    /**
     * 铜仁公安根据条件搜索
     */
    @SelectProvider(type=CustomizeSqlProvider.class, method="getTRParkInOutCount")
    Integer getTRParkInOutCount(Integer parkId, String beginDate, String endDate);


}
