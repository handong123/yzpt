package com.tasly.yzpt.service.message;


import com.tasly.yzpt.common.entity.MsgPushEntity;

public interface AsyncParserService {

    /**
     * 异步解析有赞消息
     */
    void asyncParserMessage(MsgPushEntity entity);
}
