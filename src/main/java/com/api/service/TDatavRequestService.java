package com.api.service;

import com.api.entity.TDatavRequest;
import com.api.util.PageBean;

import java.util.List;

public interface TDatavRequestService {
    PageBean<TDatavRequest> getTDatavRequestbyPage(TDatavRequest tDatavRequest, Integer page, Integer limit);
    List<TDatavRequest> getTDatavRequest(TDatavRequest tDatavRequest);
    String UpdateTDatavRequest(TDatavRequest tDatavRequest);
    String DeleteTDatavRequest(Integer id);
    TDatavRequest selectByPrimaryKey(Integer id);
    String getTDatavRequestForDataV(TDatavRequest tDatavRequest);
}
