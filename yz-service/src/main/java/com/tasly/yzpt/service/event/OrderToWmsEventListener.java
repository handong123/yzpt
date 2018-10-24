package com.tasly.yzpt.service.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OrderToWmsEventListener {
    @EventListener
    @Async
    public void listener(OrderToWmsEvent event) {
        //下发WMS
    }
}
