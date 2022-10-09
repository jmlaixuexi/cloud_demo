package com.jml.sharding.db.sharding.mapper.store;

import com.jml.sharding.db.sharding.po.Store;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {

    Store getOrderById(Long storeId);

}
