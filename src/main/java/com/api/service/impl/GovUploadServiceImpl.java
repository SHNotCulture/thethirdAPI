package com.api.service.impl;

import com.api.dao.CustomizeMapper;
import com.api.dao.TCompanyParkMapper;
import com.api.dao.TParkPortMapper;
import com.api.entity.*;
import com.api.service.GovUploadService;
import com.api.util.BeanCopyUtil;
import com.api.util.JsonUtil;
import com.api.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GovUploadServiceImpl implements GovUploadService {
    @Autowired
    private CustomizeMapper customizeMapper;
    @Autowired
    private TCompanyParkMapper tCompanyParkMapper;
    @Autowired
    private TParkPortMapper tParkPortMapper;

    @Override
    public List<GovParkInOut> getGovParkInOut(Integer parkId) {
        List<GovParkInOut> govParkInOutList = customizeMapper.getGovParkInOut(parkId);
        return govParkInOutList;
    }

    @Override
    public void updateGovUpFlag(Integer parkId,List<GovParkInOut> govParkInOuts) {
        List<String> inIds=new ArrayList<>();
        List<String> outIds=new ArrayList<>();
        for (GovParkInOut govParkInOut : govParkInOuts){
            if (govParkInOut.getGovInUpFlag()==1 & govParkInOut.getInTime()!=null){
                inIds.add("'"+govParkInOut.getId()+"'");
            }if (govParkInOut.getGovOutUpFlag()==1 && govParkInOut.getOutTime()!=null){
                outIds.add("'"+govParkInOut.getId()+"'");
            }
        }
        if (inIds.size()>0){
            customizeMapper.updateGovUpFlag(parkId,"gov_in_up_flag",inIds.toString().substring(1,inIds.toString().length()-1));
        }if (outIds.size()>0){
            customizeMapper.updateGovUpFlag(parkId,"gov_out_up_flag",outIds.toString().substring(1,outIds.toString().length()-1));
        }
    }

    @Override
    public String getCompanyParkInfo(Integer parkId) {
        String msg="";
        TCompanyPark tCompanyPark  = tCompanyParkMapper.selectByPrimaryKey(parkId);
        TParkPortCriteria tParkPortCriteria = new TParkPortCriteria();
        TParkPortCriteria.Criteria criteria = tParkPortCriteria.createCriteria();
        criteria.andParkIdEqualTo(parkId);
        List<TParkPort> tParkPorts = tParkPortMapper.selectByExample(tParkPortCriteria);
        GovCompanyPark govCompanyPark = new GovCompanyPark();
        try {
            govCompanyPark = (GovCompanyPark) BeanCopyUtil.CopyBeanToBean(tCompanyPark,govCompanyPark);
            Map map = StringUtil.object2Map(govCompanyPark);
            map.put("portList",tParkPorts);
            msg =JsonUtil.mapToJson(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("'qwe'");
        list.add("'asd'");
        System.out.println(list.toString().substring(1,list.toString().length()-1));
    }

}
