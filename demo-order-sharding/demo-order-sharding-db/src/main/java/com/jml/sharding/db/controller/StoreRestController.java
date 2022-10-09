package com.jml.sharding.db.controller;

import com.jml.sharding.db.response.StoreResponse;
import com.jml.sharding.db.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreRestController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/store/{storeId}")
    public StoreResponse storeInfo(@PathVariable Long storeId) {
        return storeService.getStore(storeId);
    }

    @GetMapping("/store/add")
    public void add() {
        storeService.insert();
    }
}
