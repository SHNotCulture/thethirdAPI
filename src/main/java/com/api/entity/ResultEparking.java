package com.api.entity;

import java.util.List;

/**
 * @Author jin
 * @Data 2019/4/24 0:13
 **/
public class ResultEparking {
    private Integer code;
    private String data;
    private String info;
    private List<FreeResult> feeResults;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<FreeResult> getFeeResults() {
        return feeResults;
    }

    public void setFeeResults(List<FreeResult> feeResults) {
        this.feeResults = feeResults;
    }
}
