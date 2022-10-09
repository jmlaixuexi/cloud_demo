package com.jml.sharding.db.sharding.mapper.storeorder;

import com.jml.sharding.db.sharding.po.StoreOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreOrderMapper {


    List<StoreOrder> queryOrderListByStore(Long storeId);

    void createOrder(StoreOrder order);

}
