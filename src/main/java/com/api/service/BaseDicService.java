package com.api.service;

import com.api.entity.TDicOuttype;
import com.api.entity.TDicPrepayType;
import com.api.entity.TParkPort;

import java.util.List;

public interface BaseDicService {
    List<TParkPort> selectParkPort(String portType);
    List<TDicOuttype> selectOutType();
    List<TDicPrepayType> selectgetPayType();

}
