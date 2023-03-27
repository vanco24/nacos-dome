package com.nole.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
@RefreshScope//SpringCloud
public class MyController {

//    @NacosValue(value = "${spring.datasource.username}", autoRefreshed = true)//这样才能动态刷新
    @Value(value = "${spring.datasource.username}")//SpingCloud
    private String username;

    @GetMapping("/test")
    public String test(){
        return username;
    }
}
