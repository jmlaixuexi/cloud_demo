package com.jml.order.controller;

import com.jml.order.model.Order;
import com.jml.order.model.User;
import com.jml.order.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/{id}",method = {RequestMethod.GET})
    public Order queryOrderById(@PathVariable("id") long id){
        return orderService.queryOrderById(id);
    }
}
