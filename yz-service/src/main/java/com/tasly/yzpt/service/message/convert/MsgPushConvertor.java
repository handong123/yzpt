package com.tasly.yzpt.service.message.convert;

import com.tasly.yzpt.common.entity.MsgPushEntity;
import com.tasly.yzpt.repository.message.entity.YzMessage;

public class MsgPushConvertor {

    public static YzMessage toBean(MsgPushEntity msgPushEntity) {
        YzMessage bean = new YzMessage();
        bean.setMsg(msgPushEntity.getMsg());
        bean.setSendCount(msgPushEntity.getSendCount());
        bean.setMode(msgPushEntity.getMode());
        bean.setAppId(msgPushEntity.getApp_id());
        bean.setClientId(msgPushEntity.getClient_id());
        bean.setVersion(msgPushEntity.getVersion());
        bean.setType(msgPushEntity.getType());
        bean.setId(msgPushEntity.getId());
        bean.setSign(msgPushEntity.getSign());
        bean.setKdtId(msgPushEntity.getKdt_id());
        bean.setKdtName(msgPushEntity.getKdt_name());
        bean.setStatus(msgPushEntity.getStatus());
        bean.setAsynStatus(0);
        return bean;
    }
}
