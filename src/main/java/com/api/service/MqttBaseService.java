package com.api.service;

import java.util.Map;

public interface MqttBaseService {
    String getCarFeeRequst(Map map, Integer parkId);
    String SendTask(Integer parkId, String data);
}
