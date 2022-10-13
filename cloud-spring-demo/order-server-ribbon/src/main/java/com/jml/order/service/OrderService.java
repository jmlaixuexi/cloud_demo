package com.jml.order.service;

import com.jml.order.model.Order;

public interface OrderService {

    public Order queryOrderById(long orderId);

}
