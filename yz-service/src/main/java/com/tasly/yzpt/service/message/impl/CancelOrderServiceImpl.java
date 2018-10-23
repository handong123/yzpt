package com.tasly.yzpt.service.message.impl;

import com.alibaba.fastjson.JSON;
import com.tasly.yzpt.service.message.CancelOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CancelOrderServiceImpl implements CancelOrderService {



    @Override
    @Transactional
    public void cancelOMSOrder(String msg) {
/*        log.info("youzan--->oms cancel order param:" + msg);
        YouzanTradeRefundGetResult result = JSON.parseObject(msg, YouzanTradeRefundGetResult.class);
        TaslyOrder taslyOrder = taslyOrderService.getTaslyOrderByOrgOrderId(result.getTid());
        if (taslyOrder == null) {
            log.info("youzan--->order does not exist");
            return;
        }
        TaslyOrderRefundDTO orderRefundDTO = new TaslyOrderRefundDTO();
        orderRefundDTO.setOriginalOrderId(result.getTid());
        ResponseDTO<String> responseDTO = orderResource.cancelOMSOrder(taslyOrder);
        log.info(responseDTO.getMessage());*/
    }

    @Override
    @Transactional
    public void goodsReturn(String msg) {
        log.info("youzan--->oms goodsReturn param:" + msg);
/*        YouzanTradeRefundGetResult refundResult = JSON.parseObject(msg, YouzanTradeRefundGetResult.class);
        String tid = refundResult.getTid();
        TaslyOrder taslyOrder = taslyOrderService.getTaslyOrderByOrgOrderId(tid);
        if (taslyOrder == null) {
            log.info("youzan--->order does not exist");
            return;
        }
        List<TaslyOrderLine> orderLines = taslyOrderService.getTaslyOrderLinesByOrderId(taslyOrder.getOrderId());

        List<TaslyOrderLine> returnOrderLines = new ArrayList<TaslyOrderLine>();
        List<OrderLinesDeliveryDetail> orderLinesDeliveryDetailList = deliveryDaoImpl.queryOrderLinesDeliveryDetailByOrderLinesId(taslyOrder.getOrderId(), refundResult.getOids());
        OrderLinesDeliveryDetail deliveryDetail = new OrderLinesDeliveryDetail();
        if (CollectionUtils.isNotEmpty(orderLinesDeliveryDetailList)) {
            deliveryDetail = orderLinesDeliveryDetailList.get(0);
        }

        for (TaslyOrderLine line : orderLines) {
            if (line.getThirdPartyOrderlineId().equals(deliveryDetail.getOrderline_id())) {
                TaslyOrderLine target = new TaslyOrderLine();
                BeanUtils.copyProperties(line, target);
                target.setGoodsReturnBathId(deliveryDetail.getBatch_num());
                target.setGoodsReturnRepertoryNo(deliveryDetail.getRepertory_num());
                target.setGoodsReturnNum(deliveryDetail.getDeliveryNum());
                returnOrderLines.add(target);
            }
        }

        TaslyOrderGoodsReturnDTO returnOrder = new TaslyOrderGoodsReturnDTO();
        returnOrder.setOriginalOrderId(tid);
        returnOrder.setOrderReturnId(refundResult.getRefundId());
        returnOrder.setOrderLines(returnOrderLines);
        ResponseDTO<String> responseDTO = orderResource.goodsReturn(returnOrder);
        log.info(responseDTO.getMessage());*/
    }
}
