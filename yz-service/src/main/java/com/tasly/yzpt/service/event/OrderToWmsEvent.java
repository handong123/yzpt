package com.tasly.yzpt.service.event;

import com.tasly.yzpt.service.message.entity.OrderEntity;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * 下发WMS事件
 */
@Data
public class OrderToWmsEvent extends ApplicationEvent {
    private OrderEntity orderEntity;

    public OrderToWmsEvent(Object source, OrderEntity orderEntity) {
        super(source);
        this.orderEntity = orderEntity;
    }
}
