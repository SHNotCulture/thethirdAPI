package com.api.service.impl;

import com.api.dao.CustomizeMapper;
import com.api.entity.TApikey;
import com.api.service.APILicenseService;
import com.api.util.MD5Util;
import com.api.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author jin
 * @Data 2019/3/14 14:46
 **/
@Service
public class APILicenseServiceImpl implements APILicenseService {
    @Autowired
    CustomizeMapper customizeMapper;
    @Override
    public Boolean theThirdAPILicense(String ID, String key) {
        Boolean status = false;
        TApikey tApikey = customizeMapper.selectApikey(ID);
        if (tApikey!=null){
            String originalKey = tApikey.getKey();
            String date1 = StringUtil.monthHOUR(-1);
            String date2 = StringUtil.monthHOUR(0);
            String KEY1 = MD5Util.MD5Encode(originalKey + date1);
            String KEY2 = MD5Util.MD5Encode(originalKey + date2);
            System.out.println("KEY:"+KEY1);
            if (key.equals(KEY1) || key.equals(KEY2)) {
                status = true;
            }
        }
        return status;
    }

    @Override
    public Boolean dataVAPILicense(String ID, String key) {
        Boolean status = false;
        TApikey tApikey = customizeMapper.selectApikey(ID);
        if (tApikey!=null){
            if (tApikey.getKey().equals(key)){
                status = true;
            }
        }
        return status;
    }
}
