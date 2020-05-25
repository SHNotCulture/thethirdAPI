package com.api.service;


import com.api.entity.TPropertyHouseholdInfo;
import com.api.entity.carOwer.HouseholdCheckRequest;
import com.api.util.PageBean;

import java.util.List;

public interface PropertyHouseholdInfoService {
    String HouseholdCheck(HouseholdCheckRequest householdCheckRequest);
    PageBean<TPropertyHouseholdInfo> getPropertyHouseholdInfobyPage(TPropertyHouseholdInfo tPropertyHouseholdInfo, Integer page, Integer limit);
    List<TPropertyHouseholdInfo> getPropertyHouseholdInfo(TPropertyHouseholdInfo tPropertyHouseholdInfo);
    String UpdatePropertyHouseholdInfo(TPropertyHouseholdInfo tPropertyHouseholdInfo);
    String DeletePropertyHouseholdInfo(Integer id);
    TPropertyHouseholdInfo getPropertyHouseholdInfoByID(Integer id);
}
