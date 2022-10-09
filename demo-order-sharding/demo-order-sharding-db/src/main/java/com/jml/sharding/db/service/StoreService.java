package com.jml.sharding.db.service;

import com.jml.sharding.db.dao.StoreDao;
import com.jml.sharding.db.po.Store;
import com.jml.sharding.db.response.StoreResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StoreService {

    @Autowired
    private StoreDao storeDao;

    public StoreResponse getStore(Long storeId) {
        Store store = storeDao.getOrderById(storeId);
        if (Objects.isNull(store)) {
            return null;
        }
        StoreResponse response = new StoreResponse();
        BeanUtils.copyProperties(store, response);
        return response;
    }

    public void insert(){
        for (int i = 0; i < 100; i++){
            Store store = new Store();
            store.setStoreName("测试源-" + i);
            storeDao.insert(store);
        }
    }
}
