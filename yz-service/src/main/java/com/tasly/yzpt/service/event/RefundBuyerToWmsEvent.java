package com.tasly.yzpt.service.event;

import com.tasly.yzpt.service.message.entity.CancelOrderEntity;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * 用户申请退款事件
 */
@Data
public class RefundBuyerToWmsEvent extends ApplicationEvent {

    private CancelOrderEntity entity;

    public RefundBuyerToWmsEvent(Object source, CancelOrderEntity entity) {
        super(source);
        this.entity = entity;
    }
}
