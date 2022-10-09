package com.jml.sharding.db.slave.po;

import lombok.Data;

@Data
public class Order {

    private Long id;

    private String orderNo;

    private Long buyerId;

    private Long storeId;

}
