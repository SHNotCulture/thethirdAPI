package com.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**/
import java.util.Map;

@FeignClient(value = "eparkingMqttClient"/*,url = "http://yun2.eparking.top:8086/mqttClient"*/)
public interface MqttClientInsideService {
    @PostMapping(value = "/mqttClient/inside/getCarFeeRequst")
    void getCarFeeRequst(@RequestBody Map map);
    @PostMapping(value = "/mqttClient/inside/getCouponUpdate")
    void getCouponUpdate(@RequestBody Map map);
    @PostMapping(value = "/mqttClient/inside/reservedCar")
    String reservedCar(@RequestBody Map map);
}
