package com.jml.sharding.db.slave.service;

import com.jml.sharding.db.slave.dao.StoreDao;
import com.jml.sharding.db.slave.po.Store;
import com.jml.sharding.db.slave.response.StoreResponse;
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
}
