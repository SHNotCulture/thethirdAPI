package com.api.service;

public interface ParkStatisticsDayService {
    /**
     * @Description:  当日银联支付订单总额。
     * @Param:
     * @return:
     * @Author: jin
     * @Date: 2019/3/25
     */
    String getUnionPayFee(Integer parkId, Integer type);
    /**
    * @Description:  当日贵州进出场车辆数
    * @Param:
    * @return:
    * @Author: jin
    * @Date: 2019/3/25
    */
    String getInAndOutVehiclesNums(Integer parkId);
    /**
    * @Description: 车位周转率
    * @Param:
    * @return:
    * @Author: jin
    * @Date: 2019/3/25
    */
    Double getParkingTurnover();
    /**
    * @Description: 银联交易占比
    * @Param:
    * @return:
    * @Author: jin
    * @Date: 2019/3/25
    */
    String getUnionPayAndTotal(Integer parkId, Integer type);
    /**
    * @Description: 各银联支付类型笔数
    * @Param:
    * @return:
    * @Author: jin
    * @Date: 2019/3/25
    */
    String getUnionPayTypeNums(Integer parkId, Integer type);
    /**
    * @Description: 查车场当日单价
    * @Param:
    * @return:
    * @Author: jin
    * @Date: 2019/3/26
    */
    /*String getUnitPrice(Integer parkId);*/
    /** 
    * @Description: 今日每小时进场车辆数 
    * @Param:  
    * @return:  
    * @Author: jin
    * @Date: 2019/3/26 
    */ 
    String getEntranceFlowAve(Integer parkId);
    /** 
    * @Description: 今日每小时出场车辆数 
    * @Param:  
    * @return:  
    * @Author: jin
    * @Date: 2019/3/26 
    */ 
    String getOutboundFlowAve(Integer parkId);
    /** 
    * @Description: 7天单车场周转率走势 
    * @Param:  
    * @return:  
    * @Author: jin
    * @Date: 2019/3/27 
    */ 
    String getWeekTurnoverTrend(Integer parkId);
            
            
}
