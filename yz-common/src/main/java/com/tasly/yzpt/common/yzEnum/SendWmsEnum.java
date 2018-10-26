package com.tasly.yzpt.common.yzEnum;

public enum  SendWmsEnum {
    SEND_WMS(0),SUCCESS_SEND_WMS(1),

    FAIL_SEND_WMS(2);

    private Integer status;

    private SendWmsEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus(){
        return status;
    }
}
