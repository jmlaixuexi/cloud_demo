package com.jml.sharding.db.slave.dao;

import com.jml.sharding.db.slave.aspect.SqlReadSlave;
import com.jml.sharding.db.slave.mapper.order.OrderMapper;
import com.jml.sharding.db.slave.po.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {

    @Autowired
    private OrderMapper orderMapper;

    @SqlReadSlave
    public List<Order> queryOrderList(Long buyerId) {
        return orderMapper.queryOrderList(buyerId);
    }
}
