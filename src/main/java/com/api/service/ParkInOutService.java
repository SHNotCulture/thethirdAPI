package com.api.service;

import com.api.entity.CloudData;
import com.api.entity.TParkInOut;
import com.api.util.PageBean;
import com.google.gson.JsonArray;

import java.util.List;

public interface ParkInOutService {
    String SaveCloudData(CloudData cloudData);
    PageBean<TParkInOut> getTParkInOutbyPage(TParkInOut tParkInOut, Integer page, Integer limit, String beginTime, String endTime);
    List<TParkInOut> getTParkInOut(TParkInOut tParkInOut, String beginTime, String endTime);
    String UpdateTParkInOut(TParkInOut tParkInOut);
    /*更新开票状态*/
    String updateBillingStatus(Integer parkId, String data);

    String getTRPoliceParkInOut(String startDateTime, String endDateTime, Integer page, Integer rows, String gg_ssjgbm_1);

    String noticeBillingStatusALL(Integer parkId, String strData);

    JsonArray getParkInOut(Integer parkId, String strData);
}
