package com.api.service.impl;

import com.api.dao.CustomizeMapper;
import com.api.dao.TCompanyParkMapper;
import com.api.dao.TParkStatisticsMapper;
import com.api.entity.TCompanyPark;
import com.api.entity.TParkStatistics;
import com.api.entity.TParkStatisticsCriteria;
import com.api.service.ParkStatisticsService;
import com.api.util.HttpClientUtil;
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
 * @Data 2019/3/25 12:12
 **/
@Service
public class ParkStatisticsServiceImpl implements ParkStatisticsService {
    @Autowired
    private CustomizeMapper customizeMapper;
    @Autowired
    private TParkStatisticsMapper tParkStatisticsMapper;
    @Autowired
    private TCompanyParkMapper tCompanyParkMapper;
    @Override
    public String getFreeParkingSpace(Integer parkId,Integer type) {
        JSONArray jsonArrayDatav = new JSONArray();
        Map mapDatav = new HashMap<>(2);
        mapDatav.put("name","今日空闲车位数");
        if (parkId!=null){
            //查询单个车场
            mapDatav.put("value",customizeMapper.getFreeParkingSpace(StringUtil.andSql(parkId),""));
        }else {
            //查询所有车场
            if (type==0){
                mapDatav.put("value",customizeMapper.getFreeParkingSpace("",""));
            }else if (type==1){
                mapDatav.put("value",customizeMapper.getFreeParkingSpace("","贵"));
            }
        }
        jsonArrayDatav.add(mapDatav);
        return JsonUtil.beanToJson(jsonArrayDatav);
    }

    @Override
    public String getParkSpacesTotal(Integer parkId) {
        JSONArray jsonArrayDatav = new JSONArray();
        TParkStatisticsCriteria tParkStatisticsCriteria = new TParkStatisticsCriteria();
        TParkStatisticsCriteria.Criteria criteria = tParkStatisticsCriteria.createCriteria();
        criteria.andParkIdEqualTo(parkId);
        List<TParkStatistics> tParkStatisticsList = tParkStatisticsMapper.selectByExample(tParkStatisticsCriteria);
        TParkStatistics tParkStatistics = new TParkStatistics();
        if (tParkStatisticsList.size()!=0){
            tParkStatistics = tParkStatisticsList.get(0);
        }else {
            tParkStatistics.setParkSpacesTotal(0);
        }
        Map mapDataV = new HashMap(2);
        mapDataV.put("name","总车位数");
        mapDataV.put("value",tParkStatistics.getParkSpacesTotal());
        jsonArrayDatav.add(mapDataV);
        return JsonUtil.beanToJson(jsonArrayDatav);
    }

    @Override
    public String getInAndOutVehiclesNumsAll(Integer parkId,Integer type) {
        JSONArray jsonArrayDatav = new JSONArray();
        Map mapDataV=null ;
        if (parkId!=null){
            //单车场历史数据
            mapDataV = customizeMapper.getInAndOutVehiclesNumsAll(StringUtil.andSql(parkId),"");
        }else {
            if (type==0){
                mapDataV = customizeMapper.getInAndOutVehiclesNumsAll("","");
            }else if (type==1){
                mapDataV = customizeMapper.getInAndOutVehiclesNumsAll("","贵");
            }
        }
        for (Object mapDataVKey : mapDataV.keySet()){
            Map mapjson = new HashMap();
            mapjson.put("name",mapDataVKey);
            mapjson.put("value",mapDataV.get(mapDataVKey));
            jsonArrayDatav.add(mapjson);
        }
        return JsonUtil.beanToJson(jsonArrayDatav);
    }

    @Override
    public String getParkingTurnover(Integer parkId,Integer type) {
        JSONArray jsonArrayDatav = new JSONArray();
        Map mapDataV = new HashMap();
        if (parkId!=null){
            //单车场历史数据
            mapDataV.put("value",customizeMapper.getParkingTurnover(StringUtil.andSql(parkId),""));
        }else {
            if (type==0){
                mapDataV.put("value",customizeMapper.getParkingTurnover("",""));
            }else if (type==1){
                mapDataV.put("value",customizeMapper.getParkingTurnover("","贵"));
            }
        }
        jsonArrayDatav.add(mapDataV);
        return JsonUtil.beanToJson(jsonArrayDatav);
    }

    @Override
    public String getParkingUsageRate(Integer parkId,Integer type) {
        JSONArray jsonArrayDatav = new JSONArray();
        Map mapDataV = new HashMap();
        if (parkId!=null){
            //单车场历史数据
            mapDataV.put("value",customizeMapper.getParkingUsageRate(StringUtil.andSql(parkId),""));
        }else {
            if (type==0){
                mapDataV.put("value",customizeMapper.getParkingUsageRate("",""));
            }else if (type==1){
                mapDataV.put("value",customizeMapper.getParkingUsageRate("","贵"));
            }
        }
        jsonArrayDatav.add(mapDataV);
        return JsonUtil.beanToJson(jsonArrayDatav);
    }

    @Override
    public String getHotSixTransaction() {
        JSONArray jsonArray = JSONArray.fromObject(HttpClientUtil.doGet("http://183.95.89.146:9011/cloud/unionDataInterfaces/getTopSixPayCountPark"));
        for (int i =0;i<jsonArray.size();i++){
            TCompanyPark tCompanyPark = tCompanyParkMapper.selectByPrimaryKey(Integer.valueOf(jsonArray.getJSONObject(i).get("parkId").toString()));
            jsonArray.getJSONObject(i).put("parkName",jsonArray.getJSONObject(i).get("parkName"));
            jsonArray.getJSONObject(i).put("url","<a href='http://yun.eparking.top/GZBZTheThirdAPI/saveDataVRequst?parkId="+jsonArray.getJSONObject(i).get("parkId")+"'>进入</a>");
        }
        //jsonArray.remove(5);
        return JsonUtil.beanToJson(jsonArray);
    }

    @Override
    public String getTopTenTransaction(Integer type) {
        JSONArray jsonArray = JSONArray.fromObject(HttpClientUtil.doGet("http://183.95.89.146:9011/cloud/unionDataInterfaces/getPayCountGuiZhouPark?type="+type));
        for (int i =0;i<jsonArray.size();i++){
            //TCompanyPark tCompanyPark = tCompanyParkMapper.selectByPrimaryKey(Integer.valueOf(jsonArray.getJSONObject(i).get("parkId").toString()));
            //if (getUrl(tCompanyPark.getId())!=null){
                jsonArray.getJSONObject(i).put("parkName",jsonArray.getJSONObject(i).get("parkName"));
                jsonArray.getJSONObject(i).put("url","<a href='http://yun.eparking.top/GZBZTheThirdAPI/saveDataVRequst?parkId="+jsonArray.getJSONObject(i).get("parkId")+"'>进入</a>");
            //}
        }
        return JsonUtil.beanToJson(jsonArray);
    }

    @Override
    public String getCoordinate(Integer type) {
        List list = new ArrayList();
        if (type==0){
            //全国
            list = customizeMapper.getCoordinate("");
        }else if (type==1){
            //贵州
            list = customizeMapper.getCoordinate("贵");
        }
        return JsonUtil.listToJson(list);
    }


    /**
     *贵州车场数
     */
    @Override
    public String parkCount(Integer type) {
        Map map=new HashMap();
        if (type==0){
            //全国
            map.put("name", "全国车场数");
            map.put("value", customizeMapper.parkCount(""));
        }
        else if (type==1) {
            //贵州
            map.put("name", "贵州车场数");
            map.put("value", customizeMapper.parkCount("贵"));
        }
        return packaging(map);
    }

    @Override
    public String getUnitPrice(Integer parkId) {
        JSONArray jsonArrayDatav = new JSONArray();
        TParkStatistics tParkStatistics  = getTParkStatistics(parkId);
        if (tParkStatistics.getPriceAve()==null){
            tParkStatistics.setPriceAve(0.00);
        }
        Map mapDataV = new HashMap(3);
        mapDataV.put("name","车场基础单价:");
        mapDataV.put("value",tParkStatistics.getPriceAve());
        mapDataV.put("id",parkId);
        jsonArrayDatav.add(mapDataV);
        return JsonUtil.beanToJson(jsonArrayDatav);
    }

    /**
     *车位总数
     */
    @Override
    public String parkSpacesSum(Integer type) {
        Map map=new HashMap();
        map.put("name","车位总数");
        if (type==0){
            //全国
            map.put("value",customizeMapper.parkSpacesSum(""));
        }
        else if (type==1) {
            //贵州
            map.put("value",customizeMapper.parkSpacesSum("贵"));
        }
        return packaging(map);
    }
    /**
     *车辆总流量
     */
    @Override
    public String outboundFlowSum(Integer type) {
        Map map=new HashMap();
        map.put("name","车辆总流量");
        if (type==0){
            //全国
            map.put("value",customizeMapper.outboundFlowSum(""));
        }
        else if (type==1){
            //贵州
            map.put("value",customizeMapper.outboundFlowSum("贵"));
        }

        return packaging(map);
    }

    @Override
    public String yearsOfTrading(Integer type) {
        Map<String,Integer> list=new HashMap<>();
        if (type==0){
            //全国
            list=customizeMapper.yearsOfTrading("");
        }
        else if (type==1){
            //贵州
            list=customizeMapper.yearsOfTrading("贵");
        }

        Map map=new HashMap();
        map.put("aims",list.get("所有车场年度交易总额目标笔数"));
        map.put("actual",list.get("所有车场历史交易笔数"));
        map.put("value",list.get("所有车场历史交易金额"));
        return packaging(map);
    }

    @Override
    public String rotationRateOfPark(Integer type) {
        List<Map<String,Integer>> list= new ArrayList<>();
        if (type==0){
            //全国
            list=customizeMapper.rotationRateOfPark("");
        }else if (type==1){
            //贵州
            list=customizeMapper.rotationRateOfPark("贵");
        }
        JSONArray jsonArray = new JSONArray();
        for(Integer temp=0;temp<list.size();temp++){
        Map map=new HashMap();
        map.put("name","车场周转率");
        map.put("time",list.get(temp).get("statistic_time"));
        map.put("value",list.get(temp).get("所有车场周转率"));
            jsonArray.add(map);
        }
        return JsonUtil.beanToJson(jsonArray);
    }


    //封装map为返回结果
    public String packaging(Map map){
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(map);
        return JsonUtil.beanToJson(jsonArray);
    }

    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("name","贵州车场数");
        map.put("value",12);
        JSONArray jsonArray = new JSONArray();
        System.out.println(jsonArray);
        jsonArray.add(map);
        System.out.println(jsonArray);
    }

    public String getUrl(Integer parkId){
        Map<Integer,String> map = new HashMap();
        map.put(202,"https://datav.aliyun.com/share/fd67d74f69d431a57351e338dd266034");
        map.put(144,"https://datav.aliyuncs.com/share/70369d6e1eae99d8e8de806f95b17a68");
        map.put(206,"https://datav.aliyuncs.com/share/8fa18cf0c6ae25b14856f5b13fa4c08c");
        map.put(219,"https://datav.aliyuncs.com/share/0ae48c0dc6a2c84c5185926117dc69b3");
        map.put(208,"https://datav.aliyuncs.com/share/c6c8551127fb19acf57070bb98b7c52f");
        map.put(234,"https://datav.aliyuncs.com/share/f5da71ff3ddf4c968d4a671f7d77a16c");
        map.put(227,"https://datav.aliyuncs.com/share/55b69b893ab83dddb3ca8e3a3c8de5e9");
        map.put(200,"https://datav.aliyuncs.com/share/c1492effe595cc29b8e6ca3fa61c9378");
        map.put(197,"https://datav.aliyuncs.com/share/d9f1f74e303a68a2085a60cfea6b183c");
        map.put(289,"https://datav.aliyuncs.com/share/e96519048f6626a69590ef163648cad7");
        String url = map.get(parkId);
        return url;
    }

    public TParkStatistics getTParkStatistics(Integer parkId){
        TParkStatisticsCriteria tParkStatisticsCriteria = new TParkStatisticsCriteria();
        TParkStatisticsCriteria.Criteria criteria = tParkStatisticsCriteria.createCriteria();
        criteria.andParkIdEqualTo(parkId);
        TParkStatistics tParkStatistics = tParkStatisticsMapper.selectByExample(tParkStatisticsCriteria).get(0);
        return tParkStatistics;
    }
}
