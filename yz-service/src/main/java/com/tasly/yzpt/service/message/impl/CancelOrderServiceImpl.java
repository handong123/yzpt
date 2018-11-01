package com.tasly.yzpt.service.message.impl;

import com.alibaba.fastjson.JSON;
import com.tasly.yzpt.common.util.DateUtil;
import com.tasly.yzpt.common.util.WidUtil;
import com.tasly.yzpt.repository.message.OidHanghaoRepository;
import com.tasly.yzpt.repository.message.TidWidRepository;
import com.tasly.yzpt.repository.message.TradeItemRepository;
import com.tasly.yzpt.repository.message.TradeRefundRepository;
import com.tasly.yzpt.repository.message.entity.*;
import com.tasly.yzpt.service.event.RefundBuyerToWmsEvent;
import com.tasly.yzpt.service.message.CancelOrderService;
import com.tasly.yzpt.service.message.convert.TradeRefundConvertor;
import com.tasly.yzpt.service.message.entity.CancelOrderEntity;
import com.tasly.yzpt.service.message.entity.CancelOrderItemEntity;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradeRefundGetResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;

@Service
@Slf4j
public class CancelOrderServiceImpl implements CancelOrderService {

    @Autowired
    private TradeItemRepository tradeItemRepository;
    @Autowired
    private TradeRefundRepository tradeRefundRepository;
    @Autowired
    private OidHanghaoRepository oidHanghaoRepository;
    @Autowired
    private TidWidRepository tidWidRepository;
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 买家发起退款
     *
     * @param msg
     */
    @Override
    @Transactional
    public void refundBuyerCreated(String msg) {
        log.info("refundBuyerCreated param:" + msg);
        YouzanTradeRefundGetResult result = JSON.parseObject(msg, YouzanTradeRefundGetResult.class);
        //保存申请退款订单信息
        TradeRefund tradeRefund = TradeRefundConvertor.toBean(result);
        tradeRefundRepository.insertSelective(tradeRefund);
        //转换为to wms 数据
        CancelOrderEntity entity = toWms(tradeRefund);
        //发送RefundBuyerToWmsEvent事件
        applicationContext.publishEvent(new RefundBuyerToWmsEvent(this, entity));
    }

    /**
     * 买家退货给卖家
     *
     * @param msg
     */
    @Override
    public void refundBuyerReturnGoods(String msg) {

    }

    private CancelOrderEntity toWms(TradeRefund tradeRefund) {
        TidWidExample tidWidExample = new TidWidExample();
        TidWidExample.Criteria criteria = tidWidExample.createCriteria();
        criteria.andTidEqualTo(tradeRefund.getTid());
        String wid = WidUtil.get(tidWidRepository.selectByExample(tidWidExample).get(0).getWid().longValue());
        OidHanghao oidHanghao = oidHanghaoRepository.selectByPrimaryKey(tradeRefund.getOid());

        TradeItemExample tradeItemExample = new TradeItemExample();
        tradeItemExample.createCriteria().andTidEqualTo(tradeRefund.getTid()).andOidEqualTo(tradeRefund.getOid());
        TradeItem tradeItem = tradeItemRepository.selectByExample(tradeItemExample).get(0);

        CancelOrderItemEntity itemEntity = new CancelOrderItemEntity();
        itemEntity.setHanghaoY(oidHanghao.getHanghao());
        itemEntity.setNum(String.valueOf(tradeItem.getNum()));

        CancelOrderEntity cancelOrderEntity = new CancelOrderEntity();
        cancelOrderEntity.setDanjNo(tradeRefund.getRefundId());
        cancelOrderEntity.setDanjNoY(wid);
        cancelOrderEntity.setHuozId("1017");
        cancelOrderEntity.setWlzxCode("1201");
        cancelOrderEntity.setRiqiDate(DateUtil.format(new Date(), "yyyyMMdd"));
        cancelOrderEntity.setCancelOrderItemEntityList(Arrays.asList(itemEntity));

        return cancelOrderEntity;
    }
}
