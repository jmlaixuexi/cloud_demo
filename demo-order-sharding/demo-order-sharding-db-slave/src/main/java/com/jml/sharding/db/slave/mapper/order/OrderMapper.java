package com.jml.sharding.db.slave.mapper.order;

import com.jml.sharding.db.slave.po.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> queryOrderList(Long buyerId);

}
