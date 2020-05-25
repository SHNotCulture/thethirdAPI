package com.api.service;

import com.api.entity.TParkReportYear;
import com.api.util.PageBean;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 18:322018-11-6
 * @Modified By:
 */
public interface ParkReportYearService {
    PageBean<TParkReportYear> getParkReportYearbyPage(String beginTime, String endTime, TParkReportYear tParkReportYear, Integer page, Integer limit);
    List<TParkReportYear> getParkReportYear(String beginTime, String endTime, TParkReportYear tParkReportYear);
    //void exportList(String beginTime, String endTime, TParkReportYear tParkReportYear, String title, HttpServletResponse response);
}
