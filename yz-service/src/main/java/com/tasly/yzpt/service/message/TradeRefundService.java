package com.tasly.yzpt.service.message;

import com.tasly.yzpt.service.message.entity.CancelOrderEntity;

public interface TradeRefundService {

    void refuse(CancelOrderEntity cancelOrderEntity);

    void agree(CancelOrderEntity cancelOrderEntity);
}
