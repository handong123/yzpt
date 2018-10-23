package com.tasly.yzpt.controller;

import com.alibaba.fastjson.JSONObject;
import com.tasly.yzpt.common.entity.MsgPushEntity;
import com.tasly.yzpt.service.message.AsyncParserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("yz")
@EnableAsync
@Slf4j
@Api("有赞消息服务相关的api")
public class PushController {

    private static final int mode = 1; //服务商


    @Autowired
    private AsyncParserService asyncParserService;
    @ApiOperation(value = "异步消息", notes = "接收有赞异步消息")
    @ApiImplicitParam(name = "entity", value = "消息实体", required = true, dataType = "MsgPushEntity")
    @RequestMapping(value = "/message", method = RequestMethod.POST, produces = "application/jsonch;arset=utf-8")
    @ResponseBody
    public String message(@RequestBody MsgPushEntity entity) {
        log.info("异步调用PushController开始" + Thread.currentThread().getId() + "   " + Thread.currentThread().getName());

        JSONObject res = new JSONObject();
        res.put("code", 0);
        res.put("msg", "success");
        String result = JSONObject.toJSONString(res);

        /**
         *  判断是否为心跳检查消息
         *  1.是则直接返回
         */

        if (entity.isTest()) {
            return result;
        }

        /**
         * 解析消息推送的模式  这步判断可以省略
         * 0-商家自由消息推送 1-服务商消息推送
         * 以服务商 举例
         * 判断是否为服务商类型的消息
         * 否则直接返回
         */
        if (entity.getMode() != mode) {
            return result;
        }

        asyncParserService.asyncParserMessage(entity);
        /**
         * 返回结果
         */
        log.info("异步调用PushController结束" + Thread.currentThread().getId() + "   " + Thread.currentThread().getName());
        return result;
    }

}
