package com.tasly.yzpt.service.message.entity;

import lombok.Data;

@Data
public class RefundToWmsEntity {
    //退款交易号
    private String refundId;
    //行号
    private String hanghao;
    //原交易号
    private String danjNoY;
    //原wms单号
    private String hanghaoY;
    //数量
    private String num;
    //物流中心编码
    private String wlzxCode;
    //货主内码
    private String huozId;
}
