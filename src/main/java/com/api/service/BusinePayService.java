package com.api.service;

import com.api.entity.TBusinePay;
import com.api.util.PageBean;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 11:162018-10-9
 * @Modified By:
 */
public interface BusinePayService {
    PageBean<TBusinePay> getTBusinePaybyPage(TBusinePay tBusinePay, Integer page, Integer limit, String beginTime, String endTime);
    List<TBusinePay> getTBusinePay(TBusinePay tBusinePay, String beginTime, String endTime);
}
