package com.tasly.yzpt.repository.message;

import com.tasly.yzpt.common.repository.MybatisBaseRepository;
import com.tasly.yzpt.repository.message.entity.TradeAddress;
import com.tasly.yzpt.repository.message.entity.TradeAddressExample;

public interface TradeAddressRepository extends
    MybatisBaseRepository<TradeAddress, String, TradeAddressExample> {

}