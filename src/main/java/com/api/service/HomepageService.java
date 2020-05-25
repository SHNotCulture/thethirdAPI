package com.api.service;

import com.api.entity.TCompanyPark;
import com.api.entity.TCustomize;

import java.util.List;
import java.util.Map;

public interface HomepageService {
    String findPresentCarNum();
    TCustomize selectNumMsg();
    Map selectHistogram(String year, String type, String parkid);
    Map selectCompanyPark();
    Map updateCompanyPark(TCompanyPark tCompanyPark);
    /**
     * 今日车流量
     */
    Integer selectTotalNum(String parkid);
    Map selectPayByType(String parkid);
    List<Map> selectSevenDays(String parkid);
    Map selectePayType(String parkid);
    Map selectCarNum(String parkid);
    Map selectMainAllNum(String parkid);

}
