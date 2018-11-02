package com.tasly.yzpt.service.message.entity;

import lombok.Data;

@Data
public class LogisticsInfoEntity {
    /**
     * 快递公司编号
     */
   private String outStype;
    /**
     * 快递编号
     */
    private String outSid;
    /**
     * 有赞行编号
     */
    private String oid;
}
