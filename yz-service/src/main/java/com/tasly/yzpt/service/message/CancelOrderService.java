package com.tasly.yzpt.service.message;

public interface CancelOrderService {

    void cancelOMSOrder(String msg);

    void goodsReturn(String msg);
}
