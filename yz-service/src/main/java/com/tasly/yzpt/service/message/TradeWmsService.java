package com.tasly.yzpt.service.message;

import com.tasly.yzpt.repository.message.entity.TradeWms;

/**
 * Created by Talsy_xiashengxin on 2018/10/31.
 */
public interface TradeWmsService {

    void insert(TradeWms tradeWms);

    void updateTradeWmsStatus(String tid);
}
