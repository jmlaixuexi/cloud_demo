package com.jml.sharding.db.dao;

import com.jml.sharding.db.mapper.store.StoreMapper;
import com.jml.sharding.db.po.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDao {

    @Autowired
    private StoreMapper storeMapper;

    public Store getOrderById(Long storeId) {
        return storeMapper.getOrderById(storeId);
    }

    public int insert(Store store){
        return storeMapper.insert(store);
    }
}
