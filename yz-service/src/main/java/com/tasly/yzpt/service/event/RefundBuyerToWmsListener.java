package com.tasly.yzpt.service.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RefundBuyerToWmsListener {
    /**
     * 申请退款订单下发WMS
     *
     * @param event
     */
    @EventListener
    @Async
    public void listener(RefundBuyerToWmsEvent event) {

    }
}
