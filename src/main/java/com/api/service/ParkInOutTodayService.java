package com.api.service;

public interface ParkInOutTodayService {
    /**
     * @Description: 查找近5秒产生的流水中的前五条
     * @Param:
     * @return:
     * @Author: jin
     * @Date: 2019/3/25
     */
    String getParkInOut(Integer parkId, Integer type);

    /**
    * @Description: 查找近5秒产生的流水数
    * @Param:
    * @return:
    * @Author: jin
    * @Date: 2019/3/25
    */
    String getParkInOutNum(Integer parkId, Integer type);
}
