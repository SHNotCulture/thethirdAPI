package com.api.service.impl;

import com.api.dao.TGlobalInfoMapper;
import com.api.entity.TGlobalInfo;
import com.api.entity.TGlobalInfoCriteria;
import com.api.service.GlobalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jin
 * @Data 2019/3/12 16:05
 **/
@Service
public class GlobalInfoServiceImpl implements GlobalInfoService {
    @Autowired
    TGlobalInfoMapper tGlobalInfoMapper;

    @Override
    public List<TGlobalInfo> getGlobalInfoByParkid(Integer parkId) {
        TGlobalInfoCriteria tGlobalInfoCriteria = new TGlobalInfoCriteria();
        TGlobalInfoCriteria.Criteria criteria = tGlobalInfoCriteria.createCriteria();
        criteria.andParkIdEqualTo(parkId);
        List<TGlobalInfo> tGlobalInfoList = tGlobalInfoMapper.selectByExample(tGlobalInfoCriteria);
        return tGlobalInfoList;
    }

    @Override
    public Integer insertOrUpdateGlobalInfo(List<TGlobalInfo> tGlobalInfosList) {
        Integer pa=0;
        TGlobalInfoCriteria tGlobalInfoCriteria = new TGlobalInfoCriteria();
        TGlobalInfoCriteria.Criteria criteria = tGlobalInfoCriteria.createCriteria();
        Integer parkId = tGlobalInfosList.get(0).getParkId();
        criteria.andParkIdEqualTo(parkId);
        tGlobalInfoMapper.deleteByExample(tGlobalInfoCriteria);
        for ( TGlobalInfo tGlobalInfo : tGlobalInfosList){
            tGlobalInfo.setId(null);
           pa += tGlobalInfoMapper.insert(tGlobalInfo);
        }
        return pa;
    }
}
