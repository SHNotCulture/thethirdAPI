package com.api.service;

import com.api.entity.TCompanyPark;
import com.api.util.PageBean;

import java.util.List;
import java.util.Map;

public interface CompanyParkService {
    PageBean<TCompanyPark> getTCompanyParkbyPage(TCompanyPark tCompanyPark, Integer page, Integer limit);
    List<TCompanyPark> getTCompanyPark(TCompanyPark tCompanyPark);
    String UpdateTCompanyPark(TCompanyPark tCompanyPark);
    String DeleteTCompanyPark(Integer id);
    TCompanyPark selectByPrimaryKey(Integer id);
    String getCompanyParkName(Integer parkID);
    /**
     * 第三方接口获取车场车位数
     */
    Map<String,Object> getParkSpaces(Integer parkId);

}
