package com.tasly.yzpt.service.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * 订单创建后，下发WMS前数据转换事件
 */
@Data
public class OrderToWmsPrepareEvent extends ApplicationEvent {
    private String tid;

    public OrderToWmsPrepareEvent(Object source, String tid) {
        super(source);
        this.tid = tid;
    }
}
