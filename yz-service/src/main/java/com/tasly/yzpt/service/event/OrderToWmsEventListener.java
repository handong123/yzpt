package com.tasly.yzpt.service.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tasly.yzpt.service.wms.WMSSendWebserviceUtil;
import com.tasly.yzpt.service.wms.WmsOrderService;
import com.tasly.yzpt.service.wms.send.INFDATA;
import com.tasly.yzpt.service.wms.send.WmsCkkpdSoap;
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
        wmsOrderService.sendToWmsOrder(event.getOrderEntity());
    }


}
