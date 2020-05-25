package com.api.thread;

import com.api.entity.MQTTResult.*;
import com.api.writeLock.CarFeeRspLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

@Async
@Component
public class MqttThread {
    private static final Logger logger = LoggerFactory.getLogger(MqttThread.class);


    /**
     * 间隔1S触发
     */
    @Scheduled(cron = "*/1 * * * * ? ")
    public void clearMqtt(){
        Collection<CarFeeRsp> carFeeRsps=CarFeeRspLock.allValues();
        if(carFeeRsps.size()>0) {
            Iterator<CarFeeRsp> iterator =carFeeRsps.iterator();
            while(iterator.hasNext()) {
                CarFeeRsp carFeeRsp=iterator.next();
                if(carFeeRsp!=null){
                    if(carFeeRsp.getTimeStamp()!=null){
                        carFeeRsp.setTimeStamp(carFeeRsp.getTimeStamp() - 1);
                    }
                    else{
                        carFeeRsp.setTimeStamp(5);
                    }
                    if (carFeeRsp.getTimeStamp() == 0) {
                        logger.info("5S自动清除计费信息，orderId:"+carFeeRsp.getOrderid());
                        iterator.remove();
                    }
                }
            }
        }
    }

}
