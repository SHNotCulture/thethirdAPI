package com.api.service.impl;

import com.api.dao.CustomizeMapper;
import com.api.dao.TCompanyParkMapper;
import com.api.entity.TCompanyPark;
import com.api.entity.TCompanyParkCriteria;
import com.api.entity.TParkInOut;
import com.api.service.ParkInOutTodayService;
import com.api.util.DateUtil;
import com.api.util.JsonUtil;
import com.api.util.StringUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author jin
 * @Data 2019/3/25 12:11
 **/
@Service
public class ParkInOutTodayServiceImpl implements ParkInOutTodayService {
    @Autowired
    private CustomizeMapper customizeMapper;
    @Autowired
    private TCompanyParkMapper tCompanyParkMapper;
    @Override
    public String getParkInOut(Integer parkId,Integer type) {
        List<TParkInOut> tParkInOutList=null;
        if (parkId!=null){
            //单车场
            tParkInOutList = customizeMapper.getParkInOut(DateUtil.getCurDateTime(), StringUtil.andSql(parkId),"");
        }else {
            if (type==0){
                //全国
                tParkInOutList = customizeMapper.getParkInOut(DateUtil.getCurDateTime(),"","");
            }else if (type==1){
                //贵州
                tParkInOutList = customizeMapper.getParkInOut(DateUtil.getCurDateTime(),"","贵");
            }
        }
        List listTParkInOutDataV = new ArrayList();
        for (TParkInOut tParkInOut : tParkInOutList){
            TCompanyParkCriteria tCompanyParkCriteria = new TCompanyParkCriteria();
            TCompanyParkCriteria.Criteria criteria = tCompanyParkCriteria.createCriteria();
            TCompanyPark tCompanyPark = tCompanyParkMapper.selectByPrimaryKey(tParkInOut.getParkId());
            String isCloudPayType = "否";
            if ("568".indexOf(tParkInOut.getEpaytype().toString())!=-1){
                isCloudPayType = "是";
            }
            Map map = new HashMap();
            map.put("parkName",tCompanyPark.getParkName());
            map.put("carPlate",tParkInOut.getInCarPlate());
            map.put("cloudPayType",isCloudPayType);
            map.put("inOutTime",tParkInOut.getOutTime()==null?tParkInOut.getInTime():tParkInOut.getOutTime());
            map.put("inOutStatus",tParkInOut.getOutTime()==null?"进场":"出场");
            listTParkInOutDataV.add(map);
        }
        return JsonUtil.listToJson(listTParkInOutDataV);
    }

    @Override
    public String getParkInOutNum(Integer parkId,Integer type) {
        JSONArray jsonArrayDatav = new JSONArray();
        Map map = new HashMap(2);
        map.put("name","本次更新流水:");
        if (parkId!=null){
            //单车场
            map.put("value",customizeMapper.getParkInOutNum(DateUtil.getCurDateTime(), StringUtil.andSql(parkId),""));
        }else {
            if (type==0){
                //全国
                map.put("value",customizeMapper.getParkInOutNum(DateUtil.getCurDateTime(),"",""));
            }else if (type==1){
                //贵州
                map.put("value",customizeMapper.getParkInOutNum(DateUtil.getCurDateTime(),"","贵"));
            }

        }
        jsonArrayDatav.add(map);
        return JsonUtil.beanToJson(jsonArrayDatav);
    }
}
