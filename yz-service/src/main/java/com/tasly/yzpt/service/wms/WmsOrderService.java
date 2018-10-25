package com.tasly.yzpt.service.wms;

import com.tasly.yzpt.service.message.entity.OrderEntity;

/**
 * Created by Talsy_xiashengxin on 2018/10/25.
 */

public interface WmsOrderService {

    void sendToWmsOrder(OrderEntity orderEntity);

}
