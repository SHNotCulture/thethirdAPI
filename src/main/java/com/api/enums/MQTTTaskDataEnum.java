package com.api.enums;

import com.api.util.DateUtil;

public enum MQTTTaskDataEnum {
    MQTTTaskDataEnum_cal_fee_request(DateUtil.getCurrenDateANY(DateUtil.sdfDateTimeFormat_II),"cal_fee_request"),
    MQTTTaskDataEnum_Task(DateUtil.getCurrenDateANY(DateUtil.sdfDateTimeFormat_II),"coupon_update")
    ;
    private String task_sn; 		// 任务sn，日期精确到毫秒
    private String task_type; 	// 任务名称

    MQTTTaskDataEnum(String task_sn, String task_type) {
        this.task_sn = task_sn;
        this.task_type = task_type;
    }

    public String getTask_sn() {
        return task_sn;
    }

    public void setTask_sn(String task_sn) {
        this.task_sn = task_sn;
    }

    public String getTask_type() {
        return task_type;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type;
    }


}
