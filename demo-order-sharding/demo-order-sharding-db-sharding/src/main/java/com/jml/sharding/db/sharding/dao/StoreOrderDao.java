package com.jml.sharding.db.sharding.dao;

import com.jml.sharding.db.sharding.mapper.storeorder.StoreOrderMapper;
import com.jml.sharding.db.sharding.po.StoreOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreOrderDao {

    @Autowired
    private StoreOrderMapper storeOrderMapper;

    public List<StoreOrder> queryOrderListByStore(Long storeId) {
        return storeOrderMapper.queryOrderListByStore(storeId);
    }

    public void createOrder(StoreOrder order) {
        storeOrderMapper.createOrder(order);
    }

}
