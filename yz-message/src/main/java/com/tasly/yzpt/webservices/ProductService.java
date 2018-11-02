package com.tasly.yzpt.webservices;

import com.tasly.yzpt.service.wms.send.INFDATA;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by Talsy_xiashengxin on 2018/10/29.
 */

@WebService(serviceName = "ProductService", // 与接口中指定的name一致
        targetNamespace = "http://webservice.yzpt.tasly.com/" // 与接口中的命名空间一致,一般是接口的包名倒
)
public interface ProductService {

    @WebMethod
    void acceptProductInfoFromWMS(@WebParam(name = "INFDATA") INFDATA INFDATA);

}
