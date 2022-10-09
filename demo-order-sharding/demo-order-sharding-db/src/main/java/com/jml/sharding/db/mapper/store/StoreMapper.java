package com.jml.sharding.db.mapper.store;

import com.jml.sharding.db.po.Order;
import com.jml.sharding.db.po.Store;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {

    Store getOrderById(Long storeId);

    int insert(Store store);
}
