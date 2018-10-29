package com.tasly.yzpt.config;

import com.tasly.yzpt.webservices.ProductService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @author Liu.Ping
 * @time 2018-9-27 上午 11:32
 * @description SOAP 配置类
 */
@Configuration
public class SoapConfig {

    @Autowired
    private ProductService productService;

    @Autowired
    private SpringBus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, productService);
        endpoint.publish("/ProductService");
        return endpoint;
    }
}