package com.api.service;

import com.api.entity.TParkCar;

public interface ParkCarService {
    TParkCar getParkCarInfoByCarPlateAndParkId(Integer parkId, String carPlate);
}
