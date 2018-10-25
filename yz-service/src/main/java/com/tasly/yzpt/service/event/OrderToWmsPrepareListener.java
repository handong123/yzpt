package com.tasly.yzpt.service.event;

import com.tasly.yzpt.repository.message.TradeAddressRepository;
import com.tasly.yzpt.repository.message.TradeInfoRepository;
import com.tasly.yzpt.repository.message.TradeItemRepository;
import com.tasly.yzpt.repository.message.entity.TradeAddress;
import com.tasly.yzpt.repository.message.entity.TradeInfo;
import com.tasly.yzpt.repository.message.entity.TradeItem;
import com.tasly.yzpt.repository.message.entity.TradeItemExample;
import com.tasly.yzpt.service.message.convert.OrderConvertor;
import com.tasly.yzpt.service.message.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class OrderToWmsPrepareListener {
    @Autowired
    private TradeInfoRepository tradeInfoRepository;
    @Autowired
    private TradeAddressRepository tradeAddressRepository;
    @Autowired
    private TradeItemRepository tradeItemRepository;
    @Autowired
    private ApplicationContext applicationContext;


    @EventListener
    @Async
    public void listener(OrderToWmsPrepareEvent event) {
        log.info("------订单创建后，下发WMS前准备事件监听------" + event.getTid());
        String tid = event.getTid();
        TradeInfo tradeInfo = tradeInfoRepository.selectByPrimaryKey(tid);
        // 行项目
        TradeItemExample tradeItemExample = new TradeItemExample();
        tradeItemExample.createCriteria().andTidEqualTo(tid);
        List<TradeItem> tradeItems = tradeItemRepository.selectByExample(tradeItemExample);
        // 地址
        TradeAddress tradeAddress = tradeAddressRepository.selectByPrimaryKey(tid);
        OrderConvertor orderConvertor = new OrderConvertor();
        OrderEntity orderEntity = orderConvertor.toBean(tradeInfo, tradeItems, tradeAddress);
        applicationContext.publishEvent(new OrderToWmsEvent(this, orderEntity));
    }
}
