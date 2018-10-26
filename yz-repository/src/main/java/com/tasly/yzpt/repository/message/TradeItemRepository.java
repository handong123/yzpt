package com.tasly.yzpt.repository.message;


import com.tasly.yzpt.common.repository.MybatisBaseRepository;
import com.tasly.yzpt.repository.message.entity.TradeItem;
import com.tasly.yzpt.repository.message.entity.TradeItemExample;

public interface TradeItemRepository extends
        MybatisBaseRepository<TradeItem, String, TradeItemExample> {
}