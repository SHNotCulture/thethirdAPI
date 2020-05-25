package com.api.service;


import com.api.entity.TGlobalInfo;

import java.util.List;

public interface GlobalInfoService {
    List<TGlobalInfo> getGlobalInfoByParkid(Integer parkId);
    Integer insertOrUpdateGlobalInfo(List<TGlobalInfo> tGlobalInfosList);
}
