package com.api.service;

import com.api.entity.TParkDuty;
import com.api.util.PageBean;

import java.util.List;

public interface CashPaymentService {
    PageBean<TParkDuty> getTParkDutyListbyPage(TParkDuty tParkDuty, String beginTime, String endTime, Integer page, Integer limit);
    List<TParkDuty> getTParkDutyList(TParkDuty tParkDuty, String beginTime, String endTime);
}

