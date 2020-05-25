package com.api.service.impl;

import com.api.dao.TParkReportYearMapper;
import com.api.entity.TParkReportYear;
import com.api.entity.TParkReportYearCriteria;
import com.api.service.ParkReportYearService;
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
 * @Date Create in 18:322018-11-6
 * @Modified By:
 */
@Service
public class ParkReportYearServiceImpl implements ParkReportYearService {
    private  static final Logger logger= LoggerFactory.getLogger(ParkReportYearServiceImpl.class);
    @Autowired
    private TParkReportYearMapper tParkReportYearMapper;
    /**
     *设置查询条件
     * @param beginTime
     * @param endTime
     * @param tParkReportYear
     * @return
     */
    private TParkReportYearCriteria setCriteria(String beginTime, String endTime, TParkReportYear tParkReportYear){
        //查询全部车场信息
        TParkReportYearCriteria tParkReportYearCriteria= new TParkReportYearCriteria();
        if(tParkReportYear!=null){
            TParkReportYearCriteria.Criteria criteria=tParkReportYearCriteria.createCriteria();
            if(tParkReportYear.getParkId()!=null)
            {
                criteria.andParkIdEqualTo(tParkReportYear.getParkId());
            }
            if(beginTime!=null&&endTime!=null &&beginTime!=""&&endTime!="")
            {
                criteria.andCreateDateBetween(beginTime,endTime);
            }

        }
        return  tParkReportYearCriteria;
    }
    /**
     * 获取数据总量
     * @param beginTime
     * @param endTime
     * @param tParkReportYear
     * @return
     */
    private Integer getCount(String beginTime, String endTime, TParkReportYear tParkReportYear){
        Integer total =(int)tParkReportYearMapper.countByExample(setCriteria( beginTime, endTime, tParkReportYear));
        return total;
    }
    /**
     * 查询年报表信息(分页)
     * @param beginTime
     * @param endTime
     * @param tParkReportYear
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageBean<TParkReportYear> getParkReportYearbyPage(String beginTime, String endTime, TParkReportYear tParkReportYear, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TParkReportYear> tParkReportYears=getParkReportYear(beginTime, endTime, tParkReportYear);
        Integer countNums =getCount(beginTime, endTime, tParkReportYear);
        PageBean<TParkReportYear> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tParkReportYears);
        return pageData;
    }
    /**
     * 查询年报表信息
     * @return
     */
    @Override
    public List<TParkReportYear> getParkReportYear(String beginTime, String endTime, TParkReportYear tParkReportYear){
        List<TParkReportYear> tParkReportYearList=tParkReportYearMapper.selectByExample(setCriteria( beginTime, endTime, tParkReportYear));
        return tParkReportYearList;
    }
    /**
     * 导出日报表信息
     * @param beginTime
     * @param endTime
     * @param tParkReportYear
     * @param title
     * @param response
     */
   /* @Override
    public void exportList(String beginTime, String endTime, TParkReportYear tParkReportYear, String title, HttpServletResponse response){
        List<TParkReportYear> tParkReportYears=getParkReportYear(beginTime, endTime, tParkReportYear);
        List<ExeclParkReportYear> execlParkReportYears=new ArrayList<>();
        logger.info("tParkReportYears:"+tParkReportYears);
        for (TParkReportYear tParkReportNew : tParkReportYears){
            ExeclParkReportYear execlParkReport = new ExeclParkReportYear();
            try {
                execlParkReport = (ExeclParkReportYear) BeanCopyUtil.CopyBeanToBean(tParkReportNew,execlParkReport);
            } catch (Exception e) {
                e.printStackTrace();
            }
            execlParkReportYears.add(execlParkReport);
        }
        try {
            ExportExcelUtil.exportExcel(response,title,title,title,execlParkReportYears);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
