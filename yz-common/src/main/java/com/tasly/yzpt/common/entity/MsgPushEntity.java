package com.tasly.yzpt.common.entity;

import lombok.Data;

@Data
public class MsgPushEntity {
    private String msg;

    private int sendCount;

    private int mode; //  默认0 : appid  1 :client

    private String app_id;

    private String client_id;

    private Long version;

    private String type;

    private String id;

    private String sign;

    private Integer kdt_id;

    private boolean test = false;

    private String status;

    private String kdt_name;

    public boolean isTest() {
        return test;
    }
}
