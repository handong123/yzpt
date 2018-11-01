package com.tasly.yzpt.service.message.entity;

import lombok.Data;

@Data
public class CancelOrderItemEntity {
    //原wms单号
    private String hanghaoY;
    //数量
    private String num;
}
