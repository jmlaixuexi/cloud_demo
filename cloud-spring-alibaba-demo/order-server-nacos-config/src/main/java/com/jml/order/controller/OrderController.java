package com.jml.order.controller;

import com.jml.order.config.PatternProperties;
import com.jml.order.model.Order;
import com.jml.order.model.User;
import com.jml.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/order")
//@RefreshScope  //nacos日志配置自动更新
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //1、通过@value注解注入，结合@RefreshScope自动更新
//    @Value("${pattern.dateformat}")
//    private String dateformat;

    //2、通过@ConfigurationProperties注入，自动更新
    @Autowired
    private PatternProperties patternProperties;

    @RequestMapping(value = "/now",method = {RequestMethod.GET})
    public String now(){
        //return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
    }


    @RequestMapping(value = "/{id}",method = {RequestMethod.GET})
    public Order queryOrderById(@PathVariable("id") long id){
        return orderService.queryOrderById(id);
    }
}
