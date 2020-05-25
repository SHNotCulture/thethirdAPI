package com.api.service;

import com.api.entity.TCarPayment;
import com.api.util.PageBean;

import java.util.List;

public interface CarPaymentService {
    List<TCarPayment> getCarPayment(TCarPayment tCarPayment, String beginData, String endData);
    PageBean<TCarPayment> getCarPaymentByPage(TCarPayment tCarPayment, String beginData, String endData, Integer page, Integer limit);
}
