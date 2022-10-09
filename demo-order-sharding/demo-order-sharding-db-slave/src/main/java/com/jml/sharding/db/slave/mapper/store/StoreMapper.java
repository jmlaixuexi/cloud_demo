package com.jml.sharding.db.slave.mapper.store;

import com.jml.sharding.db.slave.po.Store;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {

    Store getOrderById(Long storeId);

}
