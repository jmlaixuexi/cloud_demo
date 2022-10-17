package com.jml.order.service.impl;

import com.jml.order.mapper.OrderMapper;
import com.jml.order.model.Order;
import com.jml.order.model.User;
import com.jml.order.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderMapper orderMapper;

    private RestTemplate restTemplate;

    public OrderServiceImpl(OrderMapper orderMapper,RestTemplate restTemplate) {
        this.orderMapper = orderMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public Order queryOrderById(long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        //String url = "http://localhost:8181/user/"+order.getUserId();
        String url = "http://user-server/user/"+order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        return order;
    }
}
