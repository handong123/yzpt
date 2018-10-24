package com.tasly.yzpt.service.message.entity;

import lombok.Data;

@Data
public class LogisticsOnlineConfirmParams {
    /**
     * 交易编号
     */
   String tid;
    /**
     * 快递公司编号
     */
   String outStype;
    /**
     * 快递编号
     */
   String outSid;
}
