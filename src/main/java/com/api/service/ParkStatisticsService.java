package com.api.service;

public interface ParkStatisticsService {
    /**
    * @Description: 查找空余车位
    * @Param:
    * @return:
    * @Author: jin
    * @Date: 2019/3/26
    */
    String getFreeParkingSpace(Integer parkId, Integer type);
    /**
    * @Description: 查找某车场总车位数
    * @Param:
    * @return:
    * @Author: jin
    * @Date: 2019/3/26
    */
    String getParkSpacesTotal(Integer parkId);
    /**
    * @Description: 首页历史所有贵州车场进出场车辆数
    * @Param:
    * @return:
    * @Author: jin
    * @Date: 2019/3/27
    */
    String getInAndOutVehiclesNumsAll(Integer parkId, Integer type);
    /**
    * @Description: 历史周转率
    * @Param:
    * @return:
    * @Author: jin
    * @Date: 2019/3/27
    */
    String getParkingTurnover(Integer parkId, Integer type);
    /**
     * @Description: 历史占用率
     * @Param:
     * @return:
     * @Author: jin
     * @Date: 2019/3/27
     */
    String getParkingUsageRate(Integer parkId, Integer type);
    /**
    * @Description: 向武汉调用热门车场前六名并封装
    * @Param:
    * @return:
    * @Author: jin
    * @Date: 2019/3/29
    */
    String getHotSixTransaction();
    /**
    * @Description: 取固定的前十车场信息
    * @Param:
    * @return:
    * @Author: jin
    * @Date: 2019/4/1
    */
    String getTopTenTransaction(Integer type);
    /** 
    * @Description: 获取经纬度 
    * @Param:  
    * @return:  
    * @Author: jin
    * @Date: 2019/3/31 
    */ 
    String getCoordinate(Integer type);
    /**
     *贵州车场数
     */
    String parkCount(Integer type);
    /**
    * @Description: 查询车场单价
    * @Param:
    * @return:
    * @Author: jin
    * @Date: 2019/4/8
    */
    String getUnitPrice(Integer parkId);

    String parkSpacesSum(Integer type);

    String outboundFlowSum(Integer type);

    String yearsOfTrading(Integer type);

    String rotationRateOfPark(Integer type);


}
