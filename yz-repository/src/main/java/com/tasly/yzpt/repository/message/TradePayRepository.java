package com.tasly.yzpt.repository.message;

import com.tasly.yzpt.common.repository.MybatisBaseRepository;
import com.tasly.yzpt.repository.message.entity.TradePay;
import com.tasly.yzpt.repository.message.entity.TradePayExample;

public interface TradePayRepository extends
    MybatisBaseRepository<TradePay, String, TradePayExample> {
}