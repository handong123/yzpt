package com.tasly.yzpt.service.message;

public interface CancelOrderService {


    void refundBuyerCreated(String msg);

    void refundBuyerReturnGoods(String msg);
}
