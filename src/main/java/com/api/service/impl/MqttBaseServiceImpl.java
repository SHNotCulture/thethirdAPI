package com.api.service.impl;

import com.api.entity.MQTTResult.CarFeeRsp;
import com.api.service.MqttClientInsideService;
import com.api.service.MqttBaseService;
import com.api.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MqttBaseServiceImpl implements MqttBaseService {
    private  static final Logger log= LoggerFactory.getLogger(MqttBaseServiceImpl.class);
    @Autowired
    private MqttClientInsideService mqttClientInsideService;
    /**
     * 获取线下计费
     * @param map
     * @param parkId
     * @return
     */
    public String getCarFeeRequst(Map map,Integer parkId){
            Map mapMQTT=new HashMap();
            String carplate=map.get("carplate").toString();
            mapMQTT.put("carplate", carplate);
            mapMQTT.put("feeduration", map.get("feeduration"));
            mapMQTT.put("parkId",parkId);
            mqttClientInsideService.getCarFeeRequst(mapMQTT);//发送MQTT指令
           // CarFeeRsp carFeeRsp=new CarFeeRsp();
            CarFeeRsp carFeeRsp= SessionUtil.getCarFeeRsp(20,carplate,parkId.toString());
            String json=JsonUtil.beanToJson(carFeeRsp);
            return  json;
    }

    /**
     * 发送会员优惠
     * @param parkId
     * @param data
     * @return
     */
    public String SendTask(Integer parkId, String data){
        try{
            Map mapMQTT=new HashMap();
            mapMQTT.put("parkId",parkId);
            mapMQTT.put("data",data);
            mqttClientInsideService.getCouponUpdate(mapMQTT);
        }
        catch (Exception e){
            log.info(e.toString());
        }

        return "下发成功";
    }
    public static void main(String[] args) {
        String key = MD5Util.MD5Encode("47883bd731ae0fe24c2534eb435bb046" + StringUtil3.monthHOUR(-1));
        Map mapMQTT=new HashMap();
        mapMQTT.put("carplate", "粤CS9999");
        mapMQTT.put("feeduration", 0);
        Map map=new HashMap();
        map.put("service","getCarFeeRequst");
        map.put("data",JsonUtil.mapToJson(mapMQTT));
        map.put("parkId","114");
        map.put("key",key);
        map.put("ID","004");
        String params =JsonUtil.mapToJson(map);
        log.warn("params:参数:"+params);
        log.warn("停车信息,请求查询车辆缴费信息...");
        //String result = HttpRequest.getUrlResultPost(Common.wechat_getTempCarChargeInfo, params);

         String result = HttpUtil.doPost("http://yun2.eparking.top:8086/eparkingAPI/mainAction", map);
        //String result = HttpUtil.doPost("http://localhost:8086/mainAction", map);
        log.info("result:"+result);

    }
}
