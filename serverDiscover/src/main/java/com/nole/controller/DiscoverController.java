package com.nole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class DiscoverController {

    private RestTemplate restTemplate;

    @Autowired
    public DiscoverController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    /**
     * URL是  http://localhost:8080/echo/123
     */
    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string){
        return restTemplate.getForObject("http://service-provider/echo/"+string, String.class);//该url中的service-provider是服务名，echo是服务的方法
    }

}
