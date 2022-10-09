package com.jml.sharding.db.service;

import com.jml.sharding.db.dao.OrderDao;
import com.jml.sharding.db.po.Order;
import com.jml.sharding.db.po.Store;
import com.jml.sharding.db.response.OrderResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public List<OrderResponse> queryOrderList(Long buyerId) {
        return orderDao.queryOrderList(buyerId).stream().map(order -> {
            OrderResponse response = new OrderResponse();
            BeanUtils.copyProperties(order, response);
            return response;
        }).collect(Collectors.toList());
    }

    public void insert(){
        for (int i = 0; i < 100; i++){
            Order order = new Order();
            order.setOrderNo("产品编号：" + i);
            order.setBuyerId(Long.valueOf(i));
            order.setStoreId(Long.valueOf(i));
            orderDao.insert(order);
        }
    }
}
