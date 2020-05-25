package com.api.service;

import com.api.entity.TCompanyPark;
import com.api.util.PageBean;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 14:482018-9-14
 * @Modified By:
 */
public interface CarParkService {
    PageBean<TCompanyPark> getCarParkbyPage(TCompanyPark tCompanyPark, Integer page, Integer limit);
    List<TCompanyPark> getCarParkbyIDIn(List<Integer> ids);
    List<TCompanyPark> getCarPark(TCompanyPark tCompanyPark);
    String UpdateCarPark(TCompanyPark tCompanyPark);
    String DeleteCarPark(Integer id);
}
