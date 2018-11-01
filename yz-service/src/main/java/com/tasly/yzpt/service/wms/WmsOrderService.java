package com.tasly.yzpt.service.wms;

import com.tasly.yzpt.service.message.entity.CancelOrderEntity;
import com.tasly.yzpt.service.message.entity.OrderEntity;

/**
 * Created by Talsy_xiashengxin on 2018/10/25.
 */

public interface WmsOrderService {

    /**
     * 订单下传
     * @param orderEntity
     */
    void sendToWmsOrder(OrderEntity orderEntity);

    /**
     * 订单取消(没发货)
     * @param object
     */
    void cancelToWmsOrder(CancelOrderEntity object);

    /**
     * 订单取消(已经发货)
     * @param object
     */
    void sendCancelToWmsOrder(Object object);

}
