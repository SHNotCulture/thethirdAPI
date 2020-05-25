package com.api.service;

import com.api.entity.TPropertyHouseholdBill;
import com.api.entity.carOwer.HouseholdBillRequest;
import com.api.util.PageBean;

import java.util.List;

public interface PropertyHouseholdBillService {
    String HouseholdBillget(HouseholdBillRequest householdBillRequest);
    PageBean<TPropertyHouseholdBill> getPropertyHouseholdBillbyPage(TPropertyHouseholdBill tPropertyHouseholdBill, Integer page, Integer limit);
    List<TPropertyHouseholdBill> getPropertyHouseholdBill(TPropertyHouseholdBill tPropertyHouseholdBill);
    String UpdatePropertyHouseholdBill(TPropertyHouseholdBill tPropertyHouseholdBill);
    String DeletePropertyHouseholdBill(Integer id);
    TPropertyHouseholdBill getPropertyHouseholdBillByID(Integer id);
}
