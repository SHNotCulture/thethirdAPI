package com.api.service.impl;

import com.api.dao.TDicOuttypeMapper;
import com.api.dao.TDicPrepayTypeMapper;
import com.api.dao.TParkPortMapper;
import com.api.entity.*;
import com.api.service.BaseDicService;
import com.api.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

/**
 * @ClassName BaseDicServiceImpl
 * @Author jin
 * @Date 2018/9/27 15:48
 **/
@Service
public class BaseDicServiceImpl implements BaseDicService {

    @Autowired
    private TParkPortMapper tParkPortMapper;
    @Autowired
    private TDicOuttypeMapper tDicOuttypeMapper;
    @Autowired
    private TDicPrepayTypeMapper tDicPrepayTypeMapper;

    @Override
    public List<TParkPort> selectParkPort(String portType) {
        String parkid = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute(Common.ParkId).toString();
        TParkPortCriteria tParkPortCriteria = new TParkPortCriteria();
        TParkPortCriteria.Criteria criteria = tParkPortCriteria.createCriteria();
        criteria.andParkIdEqualTo(Integer.valueOf(parkid));
        if (portType==null){
            criteria.andPortTypeIsNotNull();
        }else {
            criteria.andPortTypeEqualTo(Integer.valueOf(portType));
        }
        return tParkPortMapper.selectByExample(tParkPortCriteria);
    }

    @Override
    public List<TDicOuttype> selectOutType() {
        TDicOuttypeCriteria tDicOuttypeCriteria = new TDicOuttypeCriteria();
        TDicOuttypeCriteria.Criteria criteria = tDicOuttypeCriteria.createCriteria();
        return tDicOuttypeMapper.selectByExample(tDicOuttypeCriteria);
    }

    @Override
    public List<TDicPrepayType> selectgetPayType() {
        TDicPrepayTypeCriteria tDicPrepayTypeCriteria = new TDicPrepayTypeCriteria();
        TDicPrepayTypeCriteria.Criteria criteria = tDicPrepayTypeCriteria.createCriteria();
        return tDicPrepayTypeMapper.selectByExample(tDicPrepayTypeCriteria);
    }

}
