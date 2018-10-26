package com.tasly.yzpt.service.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tasly.yzpt.service.wms.WmsOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderToWmsEventListener {

    @Autowired
    WmsOrderService wmsOrderService;


    @EventListener
    @Async
    public void listener(OrderToWmsEvent event) throws JsonProcessingException {
        log.info("------订单下发WMS事件监听------" + event.getOrderEntity().toString());
        wmsOrderService.sendToWmsOrder(event.getOrderEntity());
    }


}
