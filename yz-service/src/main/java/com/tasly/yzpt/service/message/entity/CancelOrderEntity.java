package com.tasly.yzpt.service.message.entity;

import lombok.Data;

import java.util.List;

@Data
public class CancelOrderEntity {
    //退款交易号
    private String danjNo;
    //原交易号
    private String danjNoY;
    //物流中心编码
    private String wlzxCode;
    //货主内码
    private String huozId;
    //时间
    private String riqiDate;
    //取消item
    private List<CancelOrderItemEntity> cancelOrderItemEntityList;
}
