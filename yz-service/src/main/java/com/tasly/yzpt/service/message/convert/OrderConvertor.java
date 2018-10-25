package com.tasly.yzpt.service.message.convert;

import com.tasly.yzpt.common.util.DateUtil;
import com.tasly.yzpt.common.util.GeneratorUtil;
import com.tasly.yzpt.common.yzEnum.ExpressEnum;
import com.tasly.yzpt.repository.message.entity.TradeAddress;
import com.tasly.yzpt.repository.message.entity.TradeInfo;
import com.tasly.yzpt.repository.message.entity.TradeItem;
import com.tasly.yzpt.service.message.entity.OrderEntity;
import com.tasly.yzpt.service.message.entity.OrderItemEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderConvertor {

    public OrderEntity toBean(TradeInfo tradeInfo, List<TradeItem> tradeItems, TradeAddress tradeAddress) {
        OrderEntity bean = new OrderEntity();
        //单据编号 tid
        bean.setDanjNo(tradeInfo.getTid());
        //物流中心编码 固定值1201 天津
        bean.setWlzxCode("1201");
        //货主内码  固定值 1017
        bean.setHuozId("1017");
        //单位内码 固定值 Z9999999999
        bean.setDanwId("Z9999999999");
        //单据日期 订单创建日期
        bean.setRiqiDate(DateUtil.format(tradeInfo.getPayTime(), "yyyyMMdd"));
        //提货方式  11 快递方式
        bean.setTihWay("11");
        //销售类型 1 销售
        bean.setXiaosType("1");
        //发货类型 3
        bean.setFahType("3");
        //备注
        bean.setNote("");
        //出库复核单打印要求  固定值 2
        bean.setCkdType("2");
        bean.setTiaomNum(String.valueOf(tradeItems.size()));
        List<OrderItemEntity> orderItemEntities = new ArrayList<OrderItemEntity>();
        for (TradeItem tradeItem : tradeItems) {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setHanghao(tradeItem.getOid());
            orderItemEntity.setShangpId(GeneratorUtil.getFormatted(Long.valueOf(tradeItem.getOuterItemId()), 18, "", ""));
            orderItemEntity.setNum(tradeItem.getNum().toString());
            orderItemEntity.setCarrierId(ExpressEnum.YUNDA.getYzExpressName());
            orderItemEntity.setCarrierName("韵达快递");
            orderItemEntity.setZYunFei("0");
            orderItemEntities.add(orderItemEntity);
        }
        bean.setOrderItemEntities(orderItemEntities);
        //省
        bean.setEccShiptoRegion(tradeAddress.getDeliveryProvince());
        //市
        bean.setEccShiptoCity(tradeAddress.getDeliveryCity());
        //区
        bean.setEccShiptoDistrict(tradeAddress.getDeliveryDistrict());
        //详细地址
        bean.setAddress(tradeAddress.getDeliveryAddress());
        //收货电话
        bean.setShouh_phone(tradeAddress.getReceiverTel());
        //收货人姓名
        bean.setShouhStaff(tradeAddress.getReceiverName());
        //邮编号码
        bean.setPostcode(StringUtils.isEmpty(tradeAddress.getDeliveryPostalCode()) ? "000000" : tradeAddress.getDeliveryPostalCode());
        return bean;
    }
}
