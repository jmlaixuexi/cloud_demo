package com.jml.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;

    private Long userId;

    private String name;

    private Long price;

    private Long num;

    private User user;
}