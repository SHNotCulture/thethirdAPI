package com.api.service;

import com.api.entity.TParkReport;
import com.api.util.PageBean;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 22:122018-11-1
 * @Modified By:
 */
public interface ParkReportService {
    PageBean<TParkReport> getParkReportbyPage(String beginTime, String endTime, TParkReport tParkReport, Integer page, Integer limit);
    List<TParkReport> getParkReport(String beginTime, String endTime, TParkReport tParkReport);
    String paymentForDay();
}
