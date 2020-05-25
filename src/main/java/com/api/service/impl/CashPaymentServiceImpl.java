package com.api.service.impl;

import com.api.dao.TParkDutyMapper;
import com.api.entity.TParkDuty;
import com.api.entity.TParkDutyCriteria;
import com.api.service.CashPaymentService;
import com.api.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashPaymentServiceImpl implements CashPaymentService {
    private  static final Logger logger= LoggerFactory.getLogger(CashPaymentServiceImpl.class);

    @Autowired
    private TParkDutyMapper tParkDutyMapper;


    /**
     *设置查询条件
     * @param tParkDuty
     * @param beginTime
     * @param endTime
     * @return
     */
    private TParkDutyCriteria setCriteria(TParkDuty tParkDuty, String beginTime, String endTime){
        TParkDutyCriteria tParkDutyCriteria=new TParkDutyCriteria();
        if(tParkDuty != null ){
            TParkDutyCriteria.Criteria criteria=tParkDutyCriteria.createCriteria();
            if(tParkDuty.getParkId()!=null){
                criteria.andParkIdEqualTo(tParkDuty.getParkId());
            }
            if(tParkDuty.getDutyPerson() !=null && !tParkDuty.getDutyPerson().equals("")) {
                criteria.andDutyPersonEqualTo(tParkDuty.getDutyPerson());
            }
            if(beginTime !=null && !beginTime.equals("")){
                criteria.andBeginTimeGreaterThanOrEqualTo(beginTime);
            }
            if(endTime != null && !endTime.equals("")){
                criteria.andBeginTimeLessThanOrEqualTo(endTime);
            }

        }
        return  tParkDutyCriteria;
    }

    /**
     *获取数据总量
     * @param tParkDuty
     * @param beginTime
     * @param endTime
     * @return
     */
    private Integer getCount(TParkDuty tParkDuty, String beginTime, String endTime){
        Integer total =(int)tParkDutyMapper.countByExample(setCriteria(tParkDuty,beginTime,endTime));
        return total;
    }
    /**
     * 查询现金对账记录（分页）
     * @param tParkDuty
     * @param beginTime
     * @param endTime
     * @param page
     * @param limit
     * @return
     */
    public PageBean<TParkDuty> getTParkDutyListbyPage(TParkDuty tParkDuty, String beginTime, String endTime, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TParkDuty> tParkDuties=getTParkDutyList(tParkDuty,beginTime,endTime);
        Integer countNums =getCount(tParkDuty,beginTime,endTime);
        PageBean<TParkDuty> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tParkDuties);
        return pageData;
    }

    /**
     * 查询现金对账记录
     * @param tParkDuty
     * @param beginTime
     * @param endTime
     * @return
     */
    @Override
    public List<TParkDuty> getTParkDutyList(TParkDuty tParkDuty, String beginTime, String endTime) {
        List<TParkDuty> tParkDutyList=tParkDutyMapper.selectByExample(setCriteria(tParkDuty,beginTime,endTime));
        return tParkDutyList;
    }
}


