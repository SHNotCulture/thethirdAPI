package com.api.service.impl;

import com.api.dao.CustomizeMapper;
import com.api.dao.TParkReportMapper;
import com.api.entity.TParkReport;
import com.api.entity.TParkReportCriteria;
import com.api.service.ParkReportService;
import com.api.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lishuhan
 * @Description:
 * @Date Create in 22:122018-11-1
 * @Modified By:
 */
@Service
public class ParkReportServiceImpl implements ParkReportService {
    private  static final Logger logger= LoggerFactory.getLogger(ParkReportServiceImpl.class);
    @Autowired
    private TParkReportMapper tParkReportMapper;
    @Autowired
    private CustomizeMapper customizeMapper;

    /**
     *设置查询条件
     * @param beginTime
     * @param endTime
     * @param tParkReport
     * @return
     */
    private TParkReportCriteria setCriteria(String beginTime, String endTime, TParkReport tParkReport){
        //查询日报表信息
        TParkReportCriteria tParkReportCriteria= new TParkReportCriteria();
        if(tParkReport!=null){
            TParkReportCriteria.Criteria criteria=tParkReportCriteria.createCriteria();
            if(tParkReport.getParkId()!=null)
            {
                criteria.andParkIdEqualTo(tParkReport.getParkId());
            }
            if(tParkReport.getCompanyId()!=null){
                criteria.andCompanyIdEqualTo(tParkReport.getCompanyId());
            }
            if(beginTime!=null&&endTime!=null&&beginTime!=""&&endTime!="")
            {
                criteria.andCreateDateBetween(beginTime,endTime);
            }

        }
        return  tParkReportCriteria;
    }
    /**
     * 获取数据总量
     * @param beginTime
     * @param endTime
     * @param tParkReport
     * @return
     */
    private Integer getCount(String beginTime, String endTime, TParkReport tParkReport){
        Integer total =(int)tParkReportMapper.countByExample(setCriteria( beginTime, endTime, tParkReport));
        return total;
    }
    /**
     * 查询日报表信息(分页)
     * @param beginTime
     * @param endTime
     * @param tParkReport
     * @param page
     * @param limit
     * @return
     */
    public PageBean<TParkReport> getParkReportbyPage(String beginTime, String endTime, TParkReport tParkReport, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TParkReport> tParkReportList=getParkReport(beginTime, endTime, tParkReport);
        Integer countNums =getCount(beginTime, endTime, tParkReport);
        PageBean<TParkReport> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tParkReportList);
        return pageData;
    }

    /**
     * 查询日报表信息
     * @return
     */
    public List<TParkReport> getParkReport(String beginTime, String endTime, TParkReport tParkReport){

        List<TParkReport> tParkReportList=tParkReportMapper.selectByExample(setCriteria(beginTime, endTime, tParkReport));
        return tParkReportList;
    }

    /**
     * 每日从日报表取数据至电子对账表
     * @return
     */
    public String paymentForDay()
    {
        String result="";
        Integer successNum=customizeMapper.paymentForDay();
        result= String.format("成功从日报表取出%s条数据",successNum);
        logger.info(result);
        return result;
    }
    public String statisticalToday(){

        return "统计成功";
    }
}
