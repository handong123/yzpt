package com.tasly.yzpt.service.message;

import com.tasly.yzpt.service.message.entity.TradeRefundEntity;

public interface TradeRefundService {

    void refuse(TradeRefundEntity entity);

    void agree(TradeRefundEntity entity);
}
