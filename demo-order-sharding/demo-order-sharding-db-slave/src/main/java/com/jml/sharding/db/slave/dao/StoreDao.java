package com.jml.sharding.db.slave.dao;

import com.jml.sharding.db.slave.mapper.store.StoreMapper;
import com.jml.sharding.db.slave.po.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDao {

    @Autowired
    private StoreMapper storeMapper;

    public Store getOrderById(Long storeId) {
        return storeMapper.getOrderById(storeId);
    }
}
