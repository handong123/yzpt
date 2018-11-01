package com.tasly.yzpt.service.message.impl;

import com.tasly.yzpt.repository.message.TradeLogisticsRepository;
import com.tasly.yzpt.repository.message.entity.TradeLogistics;
import com.tasly.yzpt.service.message.TradeLogisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class TradeLogisticsServiceImpl implements TradeLogisticsService {
    @Autowired
    private TradeLogisticsRepository tradeLogisticsRepository;

    @Override
    @Transactional
    public void saveLogistics(TradeLogistics tradeLogistics) {
        tradeLogisticsRepository.insertSelective(tradeLogistics);
    }
}
