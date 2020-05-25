package com.api.service;

import com.api.entity.TElectronPayment;
import com.api.util.PageBean;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 18:142018-11-6
 * @Modified By:
 */
public interface ElectronPaymentService {
    PageBean<TElectronPayment> getElectronPaymentbyPage(String beginTime, String endTime, TElectronPayment tElectronPayment, Integer page, Integer limit);

    List<TElectronPayment> getElectronPayment(String beginTime, String endTime, TElectronPayment tElectronPayment);

    String UpdateElectronPayment(TElectronPayment tElectronPayment);
}
