package com.jml.sharding.db.dao;

import com.jml.sharding.db.mapper.order.OrderMapper;
import com.jml.sharding.db.po.Order;
import com.jml.sharding.db.po.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> queryOrderList(Long buyerId) {
        return orderMapper.queryOrderList(buyerId);
    }

    public int insert(Order order){
        return orderMapper.insert(order);
    }
}
