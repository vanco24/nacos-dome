package com.nole;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Java
 */
public class Test {
    public static void main(String[] args) throws NacosException, IOException {
        /**
         * 一、配置管理
         */
//        //拉取nacos配置
//        String serverAddr = "localhost";
//        String dataId = "test";
//        String group = "DEFAULT_GROUP";
//        Properties properties = new Properties();
//        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
//        ConfigService configService = NacosFactory.createConfigService(properties);//nacos配置服务
//
//        String content = configService.getConfig(dataId, group, 5000);//获取配置
//        System.out.println(content);

        /**
         * 监听配置是否发生变化
         */
//        configService.addListener(dataId, group, new Listener() {
//            @Override
//            public void receiveConfigInfo(String configInfo) {
//                System.out.println("recieve:" + configInfo);
//            }
//
//            @Override
//            public Executor getExecutor() {
//                return null;
//            }
//        });

        /**
         * 二、服务注册
         */
        //方法一
//        NamingService naming = NamingFactory.createNamingService("localhost:8848");
//        naming.registerInstance("userService","11.11.11.11",8888);
//        System.in.read();

        //官方示例
        Properties properties = new Properties();
        properties.setProperty("serverAddr", System.getProperty("serverAddr"));
        properties.setProperty("namespace", System.getProperty("namespace"));

        NamingService naming = NamingFactory.createNamingService(properties);

        naming.registerInstance("userService", "11.11.11.11", 8888);//注册实例

//        System.out.println(naming.getAllInstances("userService"));//服务发现，即获取实例

//        naming.deregisterInstance("userService", "11.11.11.11", 8888);//删除实例

        System.in.read();

//
//        System.in.read();
//
////        boolean isPublishOk = configService.publishConfig(dataId, group, "content");
////        System.out.println(isPublishOk);
////
////        Thread.sleep(3000);
////        content = configService.getConfig(dataId, group, 5000);
////        System.out.println(content);
////
////        boolean isRemoveOk = configService.removeConfig(dataId, group);
////        System.out.println(isRemoveOk);
////        Thread.sleep(3000);
////
////        content = configService.getConfig(dataId, group, 5000);
////        System.out.println(content);
////        Thread.sleep(300000);
//
    }
}
