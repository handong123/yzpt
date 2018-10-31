package com.tasly.yzpt.service.message.convert;

import com.tasly.yzpt.common.util.DateUtil;
import com.tasly.yzpt.common.util.GeneratorUtil;
import com.tasly.yzpt.common.yzEnum.ExpressEnum;
import com.tasly.yzpt.repository.message.entity.OidHanghao;
import com.tasly.yzpt.repository.message.entity.TradeAddress;
import com.tasly.yzpt.repository.message.entity.TradeInfo;
import com.tasly.yzpt.repository.message.entity.TradeItem;
import com.tasly.yzpt.service.message.entity.OrderConvertorEntity;
import com.tasly.yzpt.service.message.entity.OrderEntity;
import com.tasly.yzpt.service.message.entity.OrderItemEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderConvertor {

    public static OrderEntity toBean(OrderConvertorEntity entity) {
        TradeInfo tradeInfo = entity.getTradeInfo();
        List<TradeItem> tradeItems = entity.getTradeItems();
        TradeAddress tradeAddress = entity.getTradeAddress();
        String wid = entity.getWid();
        Map<String, String> hanghaoMap = entity.getOidHanghaos().stream().collect(Collectors.toMap(OidHanghao::getOid, OidHanghao::getHanghao));
        OrderEntity bean = new OrderEntity();
        //单据编号 wid   因物流编号长度限制  所以转换为YZ0000000001格式 tid 保存到note中
        bean.setDanjNo(wid);
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
        //备注（保存TID）
        bean.setNote(tradeInfo.getTid());
        //出库复核单打印要求  固定值 2
        bean.setCkdType("2");
        bean.setTiaomNum(String.valueOf(tradeItems.size()));
        List<OrderItemEntity> orderItemEntities = new ArrayList<OrderItemEntity>();

        for (TradeItem tradeItem : tradeItems) {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setHanghao(hanghaoMap.get(tradeItem.getOid()));
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
