package com.jml.sharding.db.sharding.dao;

import com.jml.sharding.db.sharding.aspect.SqlReadSlave;
import com.jml.sharding.db.sharding.mapper.order.OrderMapper;
import com.jml.sharding.db.sharding.po.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {

    @Autowired
    private OrderMapper orderMapper;

    //@SqlReadSlave
    public List<Order> queryOrderList(Long buyerId) {
        return orderMapper.queryOrderList(buyerId);
    }

    public List<Order> queryOrderListByStore(Long storeId) {
        return orderMapper.queryOrderListByStore(storeId);
    }

    public void createOrder(Order order) {
        orderMapper.createOrder(order);
    }

    public Order getOrder(String orderNo) {
        return orderMapper.getOrder(orderNo);
    }
}
