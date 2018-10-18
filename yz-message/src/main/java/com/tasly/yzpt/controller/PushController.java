package com.tasly.yzpt.controller;

import com.alibaba.fastjson.JSONObject;
import com.tasly.yzpt.common.entity.MsgPushEntity;
import com.tasly.yzpt.service.message.AsyncParserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@EnableAsync
@Slf4j
public class PushController {

    private static final int mode = 1; //服务商

    @Autowired
    private YZMessageService yzMessageService;

    @Autowired
    private AsyncParserService asyncParserService;

    @RequestMapping(value = "/message", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object message(@RequestBody MsgPushEntity entity) {
        log.info("异步调用PushController开始" + Thread.currentThread().getId() + "   " + Thread.currentThread().getName());

        yzMessageService.saveMessage(entity);

        JSONObject res = new JSONObject();
        res.put("code", 0);
        res.put("msg", "success");

        /**
         *  判断是否为心跳检查消息
         *  1.是则直接返回
         */

        if (entity.isTest()) {
            return res;
        }

        /**
         * 解析消息推送的模式  这步判断可以省略
         * 0-商家自由消息推送 1-服务商消息推送
         * 以服务商 举例
         * 判断是否为服务商类型的消息
         * 否则直接返回
         */
        if (entity.getMode() != mode) {
            return res;
        }

        // asyncParserMessage.asyncParserMessage(entity);
        /**
         * 返回结果
         */
        log.info("异步调用PushController结束" + Thread.currentThread().getId() + "   " + Thread.currentThread().getName());
        return res;
    }

}
