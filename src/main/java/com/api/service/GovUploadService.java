package com.api.service;

import com.api.entity.GovParkInOut;

import java.util.List;

public interface GovUploadService {

    /*根据parkid拿流水*/
    List<GovParkInOut> getGovParkInOut(Integer parkId);
    /*修改云端状态值*/
    void updateGovUpFlag(Integer parkId, List<GovParkInOut> govParkInOuts);
    /*获取停车场额基础信息，包含通道信息*/
    String getCompanyParkInfo(Integer parkId);

}
