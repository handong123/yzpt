package com.tasly.yzpt.service.event;

import com.tasly.yzpt.common.util.GeneratorUtil;
import com.tasly.yzpt.repository.message.TidWidRepository;
import com.tasly.yzpt.repository.message.TradeAddressRepository;
import com.tasly.yzpt.repository.message.TradeInfoRepository;
import com.tasly.yzpt.repository.message.TradeItemRepository;
import com.tasly.yzpt.repository.message.entity.*;
import com.tasly.yzpt.service.message.convert.OrderConvertor;
import com.tasly.yzpt.service.message.entity.OrderConvertorEntity;
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
    private TidWidRepository tidWidRepository;
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
        //ID转换
        TidWidExample tidWidExample = new TidWidExample();
        tidWidExample.createCriteria().andTidEqualTo(tid);
        String wid = "YZ"+GeneratorUtil.getFormatted(tidWidRepository.selectByExample(tidWidExample).get(0).getWid().longValue(),10,"","") ;
        OrderConvertor orderConvertor = new OrderConvertor();
        OrderConvertorEntity entity = new OrderConvertorEntity();
        entity.setTradeAddress(tradeAddress);
        entity.setTradeInfo(tradeInfo);
        entity.setTradeItems(tradeItems);
        entity.setWid(wid);
        OrderEntity orderEntity = orderConvertor.toBean(entity);
        applicationContext.publishEvent(new OrderToWmsEvent(this, orderEntity));
    }
}
