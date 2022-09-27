package com.jml.mybatis.service;

import com.jml.mybatis.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAll();

    Product getProductById(long id);

    Product insert(Product product);
}
