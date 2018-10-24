package com.tasly.yzpt.service.message.convert;

import com.tasly.yzpt.common.util.DateUtil;
import com.tasly.yzpt.common.util.GeneratorUtil;
import com.tasly.yzpt.repository.message.entity.TradeAddress;
import com.tasly.yzpt.repository.message.entity.TradeInfo;
import com.tasly.yzpt.repository.message.entity.TradeItem;
import com.tasly.yzpt.service.message.entity.OrderEntity;
import com.tasly.yzpt.service.message.entity.OrderItemEntity;
import java.util.ArrayList;
import java.util.List;

public class OrderConvertor {

    public OrderEntity toBean(TradeInfo tradeInfo, List<TradeItem> tradeItems, TradeAddress tradeAddress) {
        OrderEntity bean = new OrderEntity();
        bean.setDanjNo(tradeInfo.getTid());
        bean.setWlzxCode("1201");
        bean.setDanwId("Z9999999999");
        bean.setRiqiDate(DateUtil.format(tradeInfo.getPayTime(), "yyyyMMdd"));
        bean.setTihWay("11");
        bean.setXiaosType("1");
        bean.setFahType("3");
        bean.setNote("");
        bean.setCkdType("2");
        bean.setTiaomNum(String.valueOf(tradeItems.size()));
        List<OrderItemEntity> orderItemEntities = new ArrayList<OrderItemEntity>();
        for (TradeItem tradeItem : tradeItems){
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setHanghao(tradeItem.getOuterItemId());
            orderItemEntity.setShangpId(GeneratorUtil.getFormatted(Long.valueOf(tradeItem.getOuterItemId()), 18, "", ""));
            orderItemEntity.setCarrierId("YUNDA");
            orderItemEntity.setCarrierName("韵达快递");

            orderItemEntities.add(orderItemEntity);
        }
        bean.setOrderItemEntities(orderItemEntities);
        bean.setEccShiptoRegion(tradeAddress.getDeliveryProvince());
        bean.setEccShiptoCity(tradeAddress.getDeliveryCity());
        bean.setEccShiptoDistrict(tradeAddress.getDeliveryAddress());
        bean.setShouh_phone(tradeAddress.getReceiverTel());
        bean.setShouhStaff(tradeAddress.getReceiverName());
        bean.setPostcode(tradeAddress.getDeliveryPostalCode());
        return bean;
    }
}
