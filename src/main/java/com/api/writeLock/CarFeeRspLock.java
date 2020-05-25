package com.api.writeLock;

import com.api.entity.MQTTResult.CarFeeRsp;
import com.api.util.RedisUtil;
import com.api.util.SessionUtil;
import com.api.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CarFeeRspLock {
    private final static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final static Lock r = rwl.readLock();
    private final static Lock w = rwl.writeLock();
    @Autowired
    private static RedisUtil redisUtil= SpringUtils.getBean(RedisUtil.class);
    public static boolean containsKey(String key){
        r.lock();
        try {
            Map<String, CarFeeRsp> carFeeRspList = new HashMap<String, CarFeeRsp>();
            //判断redis服务中是否含有CarFeeRspLock
            if(redisUtil.hasKey("CarFeeRspLock")){
                carFeeRspList=(Map<String, CarFeeRsp>)redisUtil.get("CarFeeRspLock");//得到redis的值
            }
            return carFeeRspList.containsKey(key); }
        finally { r.unlock(); }
    }
    public static Collection<CarFeeRsp> allValues() {
        r.lock();
        try {
            Map<String, CarFeeRsp> carFeeRspList = new HashMap<String, CarFeeRsp>();
            carFeeRspList=(Map<String, CarFeeRsp>)redisUtil.get("CarFeeRspLock");//得到redis的值
            return carFeeRspList.values();}
        finally { r.unlock(); }
    }
    public static  CarFeeRsp get(String key) {
        r.lock();
        try {
            Map<String, CarFeeRsp> carFeeRspList = new HashMap<String, CarFeeRsp>();
            carFeeRspList=(Map<String, CarFeeRsp>)redisUtil.get("CarFeeRspLock");//得到redis的值
            return carFeeRspList.get(key); }
        finally { r.unlock(); }
    }
    public static CarFeeRsp put(String key,CarFeeRsp value) {
        w.lock();
        try {
            Map<String, CarFeeRsp> carFeeRspList = new HashMap<String, CarFeeRsp>();
            //判断redis服务中是否含有CarFeeRspLock
            if(redisUtil.hasKey("CarFeeRspLock")){
                carFeeRspList=(Map<String, CarFeeRsp>)redisUtil.get("CarFeeRspLock");//得到redis的值
            }
            carFeeRspList.put(key, value);
            redisUtil.set("CarFeeRspLock",carFeeRspList);//存储至redis
            return value; }
        finally { w.unlock(); }
    }

    public static void remove(String key){
        w.lock();
        try {
            Map<String, CarFeeRsp> carFeeRspList = new HashMap<String, CarFeeRsp>();
            carFeeRspList=(Map<String, CarFeeRsp>)redisUtil.get("CarFeeRspLock");//得到redis的值
            carFeeRspList.remove(key);
            redisUtil.set("CarFeeRspLock",carFeeRspList);//存储至redis
        }
        finally { w.unlock(); }
    }

    public static void clear() {
        w.lock();
        try {
            Map<String, CarFeeRsp> carFeeRspList = new HashMap<String, CarFeeRsp>();
            carFeeRspList=(Map<String, CarFeeRsp>)redisUtil.get("CarFeeRspLock");//得到redis的值
            carFeeRspList.clear();
            redisUtil.set("CarFeeRspLock",carFeeRspList);//存储至redis
           }
        finally { w.unlock(); }
    }
}
