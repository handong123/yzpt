package com.tasly.yzpt.service.message.entity;

import lombok.Data;

@Data
public class CancelOrderEntity {
    private String refundId;
    private String oid;
    private String message;
}
