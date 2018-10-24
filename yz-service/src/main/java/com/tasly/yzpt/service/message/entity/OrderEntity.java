package com.tasly.yzpt.service.message.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderEntity {

  String danjNo;
  String wlzxCode;
  String huozId;
  String danwId;
  String riqiDate;
  String tihWay;
  String xiaosType;
  String fahType;
  String note;
  String ckdType;
  String tiaomNum;
  String eccShiptoRegion;
  String eccShiptoCity;
  String eccShiptoDistrict;
  String address;
  String shouh_phone;
  String shouhStaff;
  String postcode;
  List<OrderItemEntity> orderItemEntities;
}
