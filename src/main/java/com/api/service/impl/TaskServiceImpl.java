package com.api.service.impl;

import com.api.dao.CustomizeMapper;
import com.api.entity.Shop;
import com.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jin
 * @Data 2019/3/22 16:06
 **/
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private CustomizeMapper customizeMapper;

    @Override
    public String insetCouponbleWechat(Integer parkId, String carPlate) {
        Shop shop = new Shop();
        //获取出口的电脑下标
        List<String> outComputerIndexs = customizeMapper.selectComputerIndex(parkId,1);
        //向车场每个出口下发
        for(String outComputerIndex : outComputerIndexs){
            customizeMapper.insetCouponble(parkId,shop,outComputerIndex);
        }
        return null;
    }
}
