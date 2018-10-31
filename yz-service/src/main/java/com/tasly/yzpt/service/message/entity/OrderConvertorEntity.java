package com.tasly.yzpt.service.message.entity;

import com.tasly.yzpt.repository.message.entity.OidHanghao;
import com.tasly.yzpt.repository.message.entity.TradeAddress;
import com.tasly.yzpt.repository.message.entity.TradeInfo;
import com.tasly.yzpt.repository.message.entity.TradeItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderConvertorEntity {
    TradeInfo tradeInfo;
    List<TradeItem> tradeItems;
    TradeAddress tradeAddress;
    String wid;
    List<OidHanghao> oidHanghaos;
}
