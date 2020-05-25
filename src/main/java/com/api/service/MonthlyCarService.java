package com.api.service;


import com.alibaba.fastjson.JSONObject;
import com.api.entity.TCarPayment;
import com.api.entity.TCustomize;
import com.api.entity.TParkCar;
import com.api.util.PageBean;

import java.util.List;

public interface MonthlyCarService {
    PageBean<TParkCar> getTParkCarlistbyPage(TParkCar tParkCar, Integer page, Integer limit);
    List<TParkCar> getTParkCarlist(TParkCar tParkCar);
    TCustomize getCarNum(String parkid);
    TParkCar UpdateTParkCar(TParkCar tParkCar);
    List<TParkCar> getCloseParkCar(String closeType, String payRule, String parkid);
    JSONObject getNeedPay(Integer payStandard, Integer payCount, TParkCar tParkCar);
    TParkCar getParkCar(Integer id);
    String Resetport(String portids, String ids);
    Integer getMaturityNo(String parkid);
    TParkCar getTParkCarById(Integer id);
    String correct(TParkCar ParkCar, TCarPayment CarPayment);//冲正
    String refund(TParkCar parkCar, TCarPayment carPayment, String isRefund);//删除
    String recharge(TCarPayment carPayment, TParkCar parkCar);//充值
    List<TParkCar> whetherParkCar(Integer parkId, String carPlate);
}
