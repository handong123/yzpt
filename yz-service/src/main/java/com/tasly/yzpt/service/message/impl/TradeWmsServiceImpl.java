package com.tasly.yzpt.service.message.impl;

import com.tasly.yzpt.common.yzEnum.SendWmsEnum;
import com.tasly.yzpt.repository.message.TradeWmsRepository;
import com.tasly.yzpt.repository.message.entity.TradeWms;
import com.tasly.yzpt.repository.message.entity.TradeWmsExample;
import com.tasly.yzpt.service.message.TradeWmsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Talsy_xiashengxin on 2018/10/31.
 */
public class TradeWmsServiceImpl implements TradeWmsService {

    @Autowired
    TradeWmsRepository tradeWmsRepository;

    @Override
    public void insert(TradeWms tradeWms) {
        tradeWmsRepository.insert(tradeWms);
    }

    @Override
    public void updateTradeWmsStatus(String tid) {
        TradeWms tradeWms = new TradeWms();
        tradeWms.setStatus(SendWmsEnum.SUCCESS_SEND_WMS.getStatus());
        TradeWmsExample tradeWmsExample = new TradeWmsExample();
        tradeWmsExample.or().andTidEqualTo(tid);
        tradeWmsRepository.updateByExampleSelective(tradeWms,tradeWmsExample);
    }

}
