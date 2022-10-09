package com.jml.sharding.db.sharding.po;

import lombok.Data;

@Data
public class Order {

    private Long id;

    private String orderNo;

    private Long buyerId;

    private Long storeId;

}
