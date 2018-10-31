package com.tasly.yzpt.service.event;

import com.tasly.yzpt.service.message.entity.RefundToWmsEntity;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class RefundBuyerToWmsEvent extends ApplicationEvent {

    private RefundToWmsEntity entity;

    public RefundBuyerToWmsEvent(Object source, RefundToWmsEntity entity) {
        super(source);
        this.entity = entity;
    }
}
