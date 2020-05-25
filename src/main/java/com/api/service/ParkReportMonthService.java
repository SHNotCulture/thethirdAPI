package com.api.service;

import com.api.entity.TParkReportMonth;
import com.api.util.PageBean;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 18:262018-11-6
 * @Modified By:
 */
public interface ParkReportMonthService {
    PageBean<TParkReportMonth> getParkReportMonthbyPage(String beginTime, String endTime, TParkReportMonth tParkReportMonth, Integer page, Integer limit);
    List<TParkReportMonth> getParkReportMonth(String beginTime, String endTime, TParkReportMonth tParkReportMonth);
}
