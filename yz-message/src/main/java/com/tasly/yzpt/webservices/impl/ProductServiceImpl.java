package com.tasly.yzpt.webservices.impl;

import com.google.common.collect.Lists;
import com.tasly.yzpt.common.util.JsonUtil;
import com.tasly.yzpt.service.wms.send.INFDATA;
import com.tasly.yzpt.webservices.ProductService;
import com.tasly.yzpt.webservices.dto.DATA;
import com.tasly.yzpt.webservices.dto.RETDATA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Talsy_xiashengxin on 2018/10/29.
 */
@WebService(serviceName = "ProductService", // 与接口中指定的name一致
        targetNamespace = "http://webservice.yzpt.tasly.com/"// 与接口中的命名空间一致,一般是接口的包名倒
)

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Override
    public void acceptProductInfoFromWMS(@WebParam(name = "INFDATA") INFDATA infoData) {
        log.info("WMS推送商品主数据:" + JsonUtil.bean2Json(infoData));
        DATA result = new DATA();
        List<RETDATA> retdataList = Lists.newArrayList();
        RETDATA retdata = new RETDATA();
        retdataList.add(retdata);
        result.setRetdata(retdataList);

    }
}
