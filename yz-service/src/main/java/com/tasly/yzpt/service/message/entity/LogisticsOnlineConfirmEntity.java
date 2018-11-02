package com.tasly.yzpt.service.message.entity;

import lombok.Data;

import java.util.List;

@Data
public class LogisticsOnlineConfirmEntity {
    /**
     * 有赞交易编号
     */
   String tid;
    /**
     *
     */
    private List<LogisticsInfoEntity> logisticsInfoEntityList;
}
