package com.tasly.yzpt.service.event;

import com.tasly.yzpt.service.wms.WmsOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RefundBuyerToWmsListener {

    @Autowired
    WmsOrderService wmsOrderService;
    /**
     * 申请退款订单下发WMS
     *
     * @param event
     */
    @EventListener
    @Async
    public void listener(RefundBuyerToWmsEvent event) {
        wmsOrderService.sendCancelToWmsOrder(event.getEntity());
    }
}
