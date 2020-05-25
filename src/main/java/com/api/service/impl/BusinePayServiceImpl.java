package com.api.service.impl;

import com.api.dao.TBusinePayMapper;
import com.api.entity.TBusinePay;
import com.api.entity.TBusinePayCriteria;
import com.api.service.BusinePayService;
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
 * @Date Create in 11:162018-10-9
 * @Modified By:
 */
@Service
public class BusinePayServiceImpl implements BusinePayService {
    private  static final Logger logger= LoggerFactory.getLogger(BusinePayServiceImpl.class);
    @Autowired
    private TBusinePayMapper tBusinePayMapper;

    /**
     * 设置查询条件
     * @param tBusinePay
     * @return
     */
    private TBusinePayCriteria setCriteria(TBusinePay tBusinePay, String beginTime, String endTime){
        TBusinePayCriteria tBusinePayCriteria= new TBusinePayCriteria();
        if(tBusinePay!=null){
            TBusinePayCriteria.Criteria criteria=tBusinePayCriteria.createCriteria();
            if(tBusinePay.getParkId()!=null)
            {
                criteria.andParkIdEqualTo(tBusinePay.getParkId());
            }
            if(tBusinePay.getBusineName()!=null)
            {
                criteria.andBusineNameLike("%"+tBusinePay.getBusineName()+"%");
            }
            if(tBusinePay.getCompanyId()!=null){
                criteria.andCompanyIdEqualTo(tBusinePay.getCompanyId());
            }
            if(beginTime!=null&&endTime!=null&&beginTime!=""&&endTime!="")
            {
                criteria.andPayTimeBetween(beginTime,endTime);
            }
            tBusinePayCriteria.setOrderByClause("pay_time DESC");
        }
        return tBusinePayCriteria;
    }
    /**
     * 获取数据总量
     * @param tBusinePay
     * @return
     */
    private Integer getCount(TBusinePay tBusinePay, String beginTime, String endTime){
        Integer total =(int)tBusinePayMapper.countByExample(setCriteria(tBusinePay,beginTime,endTime));
        return total;
    }
    /**
     *查询商户充值记录(分页)
     * @param tBusinePay
     * @param page
     * @param limit
     * @return
     */
    public PageBean<TBusinePay> getTBusinePaybyPage(TBusinePay tBusinePay, Integer page, Integer limit, String beginTime, String endTime){
        PageHelper.startPage(page, limit,"id desc");
        List<TBusinePay> tBusinePayList=getTBusinePay(tBusinePay,beginTime,endTime);
        Integer countNums =getCount(tBusinePay,beginTime,endTime);
        PageBean<TBusinePay> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tBusinePayList);
        return pageData;
    }
    /**
     * 查询商户充值记录
     * @return
     */
    public List<TBusinePay> getTBusinePay(TBusinePay tBusinePay, String beginTime, String endTime){
        List<TBusinePay> tBusinePayList=tBusinePayMapper.selectByExample(setCriteria(tBusinePay,beginTime,endTime));
        return tBusinePayList;
    }


}
