package com.api.service;

import com.api.entity.THouseholdFeedback;
import com.api.entity.carOwer.HouseholdFeedbackRequest;
import com.api.util.PageBean;

import java.util.List;

public interface HouseholdFeedbackServcie {
    String HouseholdFeedback(HouseholdFeedbackRequest householdFeedbackRequest);
    PageBean<THouseholdFeedback> getHouseholdFeedbackbyPage(THouseholdFeedback tHouseholdFeedback, Integer page, Integer limit);
    List<THouseholdFeedback> getHouseholdFeedback(THouseholdFeedback tHouseholdFeedback);
    String UpdateHouseholdFeedback(THouseholdFeedback tHouseholdFeedback);
    String DeleteHouseholdFeedback(Integer id);
    THouseholdFeedback getHouseholdFeedbackByID(Integer id);
}
