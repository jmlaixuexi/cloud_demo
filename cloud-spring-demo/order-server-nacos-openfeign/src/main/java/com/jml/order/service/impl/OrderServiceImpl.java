package com.jml.order.service.impl;

import com.jml.feign.clients.UserClient;
import com.jml.feign.model.User;
import com.jml.order.mapper.OrderMapper;
import com.jml.order.model.Order;
import com.jml.order.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderMapper orderMapper;

    private RestTemplate restTemplate;

    private UserClient userClient;

    public OrderServiceImpl(OrderMapper orderMapper,RestTemplate restTemplate,UserClient userClient) {
        this.orderMapper = orderMapper;
        this.restTemplate = restTemplate;
        this.userClient = userClient;
    }

    @Override
    public Order queryOrderById(long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
//        String url = "http://localhost:8181/user/"+order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
        User user = userClient.findUserById(order.getUserId());
        order.setUser(user);
        return order;
    }
}
