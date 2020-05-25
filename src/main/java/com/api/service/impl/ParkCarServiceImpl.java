package com.api.service.impl;

import com.api.dao.TParkCarMapper;
import com.api.entity.TParkCar;
import com.api.entity.TParkCarCriteria;
import com.api.service.ParkCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkCarServiceImpl implements ParkCarService {
    @Autowired
    private TParkCarMapper tParkCarMapper;

    @Override
    public TParkCar getParkCarInfoByCarPlateAndParkId(Integer parkId, String carPlate) {
        TParkCar tParkCar = new TParkCar();
        TParkCarCriteria tParkCarCriteria = new TParkCarCriteria();
        TParkCarCriteria.Criteria criteria = tParkCarCriteria.createCriteria();
        criteria.andParkIdEqualTo(parkId);
        criteria.andCarPlateLike("%"+carPlate+"%");
        List<TParkCar> tParkCarList = tParkCarMapper.selectByExample(tParkCarCriteria);
        if (tParkCarList.size()>0){
            tParkCar = tParkCarList.get(0);
        }
        return tParkCar;
    }
}
