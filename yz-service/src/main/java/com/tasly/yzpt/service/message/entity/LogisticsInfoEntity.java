package com.tasly.yzpt.service.message.entity;

import lombok.Data;

@Data
public class LogisticsInfoEntity {
    /**
     * 快递公司编号
     */
   private String outStype;
    /**
     * 有赞快递编号  1-STO 4-YUNDA 25-ZJS  有赞编号为 1 4 25
     */
    private String outSid;
    /**
     * 有赞行编号
     */
    private String oid;
}
