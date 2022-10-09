package com.jml.sharding.db.mapper.order;

import com.jml.sharding.db.po.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> queryOrderList(Long buyerId);

    int insert(Order order);

}
