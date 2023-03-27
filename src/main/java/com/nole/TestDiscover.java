package com.nole;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.listener.NamingEvent;

import java.io.IOException;
import java.util.Properties;

/**
 * Java 服务发现
 */
public class TestDiscover {
    public static void main(String[] args) throws NacosException, IOException {
        Properties properties = new Properties();
        properties.setProperty("serverAddr", System.getProperty("serverAddr"));
        properties.setProperty("namespace", System.getProperty("namespace"));

        NamingService naming = NamingFactory.createNamingService(properties);
        System.out.println(naming.getAllInstances("userService"));//获取服务实例
        naming.selectOneHealthyInstance("userService");//随机获取一个健康的服务实例

        /**
         * 监听服务的变动
         */
        naming.subscribe("userService", event -> {
            System.out.println(((NamingEvent)event).getServiceName());
            System.out.println(((NamingEvent)event).getInstances());
        });

        System.in.read();
    }
}
