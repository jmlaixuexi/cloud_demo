package com.jml.order.controller;

import com.jml.order.model.Order;
import com.jml.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/{id}",method = {RequestMethod.GET})
    public Order queryOrderById(@PathVariable("id") long id,@RequestHeader(value = "Token",required = false) String token){
        logger.info("Toke：" + token);
        return orderService.queryOrderById(id);
    }
}
