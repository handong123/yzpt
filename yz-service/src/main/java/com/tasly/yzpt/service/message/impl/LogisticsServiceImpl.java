package com.tasly.yzpt.service.message.impl;

import com.tasly.yzpt.common.util.RestClient;
import com.tasly.yzpt.repository.message.TradeAddressRepository;
import com.tasly.yzpt.repository.message.TradeInfoRepository;
import com.tasly.yzpt.repository.message.TradeItemRepository;
import com.tasly.yzpt.repository.message.TradePayRepository;
import com.tasly.yzpt.repository.message.entity.TradeAddress;
import com.tasly.yzpt.repository.message.entity.TradeInfo;
import com.tasly.yzpt.repository.message.entity.TradeItem;
import com.tasly.yzpt.repository.message.entity.TradeItemExample;
import com.tasly.yzpt.service.message.LogisticsService;
import com.tasly.yzpt.service.message.convert.OrderConvertor;
import com.tasly.yzpt.service.message.entity.OrderEntity;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogisticsServiceImpl implements LogisticsService{

  @Autowired
  private TradeInfoRepository tradeInfoRepository;
  @Autowired
  private TradePayRepository tradePayRepository;
  @Autowired
  private TradeAddressRepository tradeAddressRepository;
  @Autowired
  private TradeItemRepository tradeItemRepository;
  @Autowired
  private RestClient restClient;

  @Override
  public boolean sendOrderInfo(final String tid){
    TradeInfo tradeInfo = tradeInfoRepository.selectByPrimaryKey(tid);
    // 行项目
    TradeItemExample tradeItemExample = new TradeItemExample();
    tradeItemExample.createCriteria().andTidEqualTo(tid);
    List<TradeItem> tradeItems = tradeItemRepository.selectByExample(tradeItemExample);
    // 地址
    TradeAddress tradeAddress = tradeAddressRepository.selectByPrimaryKey(tid);
    OrderConvertor orderConvertor = new OrderConvertor();
    OrderEntity orderEntity = orderConvertor.toBean(tradeInfo, tradeItems, tradeAddress);

  //  restClient.postJson("", orderEntity);
     return true;
  }

}
