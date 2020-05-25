package com.api.service.impl;

import com.api.dao.TCarPaymentMapper;
import com.api.entity.TCarPayment;
import com.api.entity.TCarPaymentCriteria;
import com.api.service.CarPaymentService;
import com.api.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPaymentServiceImpl implements CarPaymentService {
    @Autowired
    private TCarPaymentMapper tCarPaymentMapper;

    @Override
    public List<TCarPayment> getCarPayment(TCarPayment tCarPayment, String beginData, String endData) {
        return tCarPaymentMapper.selectByExample(setCriteria(tCarPayment, beginData, endData));
    }

    @Override
    public PageBean<TCarPayment> getCarPaymentByPage(TCarPayment tCarPayment, String beginData, String endData, Integer page, Integer limit) {
        PageHelper.startPage(page, limit,"id desc");
        List<TCarPayment> tCarPaymentList = getCarPayment(tCarPayment, beginData, endData);
        Integer countNums =getCount(tCarPayment, beginData, endData);
        PageBean<TCarPayment> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tCarPaymentList);
        return pageData;
    }

    private TCarPaymentCriteria setCriteria(TCarPayment tCarPayment, String beginData, String endData){
        TCarPaymentCriteria tCarPaymentCriteria = new TCarPaymentCriteria();
        TCarPaymentCriteria.Criteria criteria = tCarPaymentCriteria.createCriteria();
        if (tCarPayment!=null){
            if (tCarPayment.getParkId()!=null){
                criteria.andParkIdEqualTo(tCarPayment.getParkId());
            }if (tCarPayment.getPayRule()!=null){
                criteria.andPayRuleEqualTo(tCarPayment.getPayRule());
            }if (tCarPayment.getCarplate()!=null){
                criteria.andCarplateLike("%"+tCarPayment.getCarplate()+"%");
            }
        }
        if (beginData.length()>0){
            criteria.andPayTimeGreaterThanOrEqualTo(beginData);
        }
        if (endData.length()>0){
            criteria.andPayTimeLessThanOrEqualTo(endData);
        }
        return tCarPaymentCriteria;
    }

    private Integer getCount(TCarPayment tCarPayment, String beginData, String endData){
        return (int)tCarPaymentMapper.countByExample(setCriteria(tCarPayment, beginData, endData));
    }
}
