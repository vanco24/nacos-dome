package com.nole.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope//SpringCloud, 自动刷新配置
public class EchoController {

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String get(@PathVariable String string){
        return "Hello Nacos Discovery " + string;
    }
}
