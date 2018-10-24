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
        //创建数据trade-wms 默认0 等到wms返回信息更新为1
    }
}
