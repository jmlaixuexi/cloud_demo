package com.jml.sharding.db.response;

import lombok.Data;

@Data
public class OrderResponse {

    private String orderNo;

    private Long buyerId;

    private Long storeId;

}
