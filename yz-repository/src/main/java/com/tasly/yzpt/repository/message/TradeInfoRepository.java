package com.tasly.yzpt.repository.message;

import com.tasly.yzpt.common.repository.MybatisBaseRepository;
import com.tasly.yzpt.repository.message.entity.TradeInfo;
import com.tasly.yzpt.repository.message.entity.TradeInfoExample;

public interface TradeInfoRepository extends
    MybatisBaseRepository<TradeInfo, String, TradeInfoExample> {
}