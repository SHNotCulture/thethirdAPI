package com.api.service.impl;

import com.api.dao.CustomizeMapper;
import com.api.dao.TParkStatisticsDayMapper;
import com.api.entity.TParkStatisticsDay;
import com.api.entity.TParkStatisticsDayCriteria;
import com.api.service.ParkStatisticsDayService;
import com.api.util.JsonUtil;
import com.api.util.StringUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author jin
 * @Data 2019/3/25 12:12
 **/
@Service
public class ParkStatisticsDayServiceImpl implements ParkStatisticsDayService {
    @Autowired
    private CustomizeMapper customizeMapper;
    @Autowired
    private TParkStatisticsDayMapper tParkStatisticsDayMapper;
    @Override
    public String getUnionPayFee(Integer parkId,Integer type) {
        JSONArray jsonArrayDatav = new JSONArray();
        Map mapDatav = new HashMap<>(2);
        mapDatav.put("name","今日交易总额");
        if (parkId!=null){
            //查询单个车场
            mapDatav.put("value",customizeMapper.getAllUnionPayFeeToday(StringUtil.andSql(parkId),""));
        }else {
            //查询所有车场
            if (type==0){
                //全国
                mapDatav.put("value",customizeMapper.getAllUnionPayFeeToday("",""));
            }else if (type==1){
                //贵州
                mapDatav.put("value",customizeMapper.getAllUnionPayFeeToday("","贵"));
            }
        }
        jsonArrayDatav.add(mapDatav);
        return JsonUtil.beanToJson(jsonArrayDatav);
    }

    @Override
    public String getInAndOutVehiclesNums(Integer parkId) {
        JSONArray jsonArrayDatav = new JSONArray();
        Map<String,Integer> map;
        if (parkId!=null){
            //单车场
             map = customizeMapper.getInAndOutVehiclesNums(StringUtil.andSql(parkId));
        }else {
            //所有车场
             map = customizeMapper.getInAndOutVehiclesNums("");
        }
        for (String mapKey : map.keySet()){
            Map mapjson = new HashMap();
            mapjson.put("name",mapKey);
            mapjson.put("value",map.get(mapKey));
            jsonArrayDatav.add(mapjson);
        }
        return JsonUtil.beanToJson(jsonArrayDatav);
    }

    @Override
    public Double getParkingTurnover() {
        return null;
    }

    @Override
    public String getUnionPayAndTotal(Integer parkId,Integer type) {
        JSONArray jsonArrayDatav = new JSONArray();
        Map map=new HashMap();
        if (parkId!=null){
            //单车场
            map = customizeMapper.getUnionPayAndTotal(StringUtil.andSql(parkId),"");
        }else{
            if (type==0){
                //全国
                map = customizeMapper.getUnionPayAndTotal("","");
            }else if (type==1){
                //贵州
                map = customizeMapper.getUnionPayAndTotal("","贵");
            }

        }
        jsonArrayDatav.add(map);
        return JsonUtil.beanToJson(jsonArrayDatav);
    }

    @Override
    public String getUnionPayTypeNums(Integer parkId,Integer type) {
        JSONArray jsonArrayDatav = new JSONArray();
        Map<String,Integer> map=new HashMap<>();
        if (parkId!=null){
            //单车场
            map = customizeMapper.getUnionPayTypeNums(StringUtil.andSql(parkId),"");
        }else{
            if (type==0){
                //全国
                map = customizeMapper.getUnionPayTypeNums("","");
            }else if (type==1){
                //贵州
                map = customizeMapper.getUnionPayTypeNums("","贵");
            }

        }
        for (String mapKey : map.keySet()){
            Map mapDataV = new HashMap<>(2);
            mapDataV.put("name",mapKey);
            mapDataV.put("value",map.get(mapKey));
            jsonArrayDatav.add(mapDataV);
        }
        return JsonUtil.beanToJson(jsonArrayDatav);
    }

    /*@Override
    public String getUnitPrice(Integer parkId) {
        JSONArray jsonArrayDatav = new JSONArray();
        TParkStatisticsDay tParkStatisticsDay  = getTParkStatisticsDay(parkId);
        if (tParkStatisticsDay.getParkId()==null){
            tParkStatisticsDay.setPriceAve(0.00);
        }
        Map mapDataV = new HashMap(3);
        mapDataV.put("name","车场基础单价:");
        mapDataV.put("value",tParkStatisticsDay.getPriceAve());
        mapDataV.put("id",parkId);
        jsonArrayDatav.add(mapDataV);
        return JsonUtil.beanToJson(jsonArrayDatav);
    }*/

    @Override
    public String getEntranceFlowAve(Integer parkId) {
        JSONArray jsonArrayDatav = new JSONArray();
        TParkStatisticsDay tParkStatisticsDay  = getTParkStatisticsDay(parkId);
        if (tParkStatisticsDay.getParkId()==null){
            tParkStatisticsDay.setEntranceFlowAve(0.00);
        }
        Map mapDataV = new HashMap(2);
        mapDataV.put("name","进场流量");
        mapDataV.put("value",tParkStatisticsDay.getEntranceFlowAve());
        jsonArrayDatav.add(mapDataV);
        return JsonUtil.beanToJson(jsonArrayDatav);
    }

    @Override
    public String getOutboundFlowAve(Integer parkId) {
        JSONArray jsonArrayDatav = new JSONArray();
        TParkStatisticsDay tParkStatisticsDay  = getTParkStatisticsDay(parkId);
        if (tParkStatisticsDay.getParkId()==null){
            tParkStatisticsDay.setOutboundFlowAve(0.00);
        }
        Map mapDataV = new HashMap(2);
        mapDataV.put("name","出场流量");
        mapDataV.put("value",tParkStatisticsDay.getOutboundFlowAve());
        jsonArrayDatav.add(mapDataV);
        return JsonUtil.beanToJson(jsonArrayDatav);
    }

    @Override
    public String getWeekTurnoverTrend(Integer parkId) {
        List list = customizeMapper.getWeekTurnoverTrend(StringUtil.andSql(parkId));
        return JsonUtil.listToJson(list);
    }

    public TParkStatisticsDay  getTParkStatisticsDay(Integer parkId){
        TParkStatisticsDay tParkStatisticsDay = new TParkStatisticsDay();
        TParkStatisticsDayCriteria tParkStatisticsDayCriteria = new TParkStatisticsDayCriteria();
        TParkStatisticsDayCriteria.Criteria criteria = tParkStatisticsDayCriteria.createCriteria();
        criteria.andParkIdEqualTo(parkId);
        List<TParkStatisticsDay> tParkStatisticsDays  = tParkStatisticsDayMapper.selectByExample(tParkStatisticsDayCriteria);
        if (tParkStatisticsDays.size()==0){
            return tParkStatisticsDay;
        }else {
        return tParkStatisticsDays.get(0);
        }
    }
}
