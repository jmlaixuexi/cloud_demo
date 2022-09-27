package com.jml.mybatis.service.impl;

import com.jml.mybatis.mapper.ProductMapper;
import com.jml.mybatis.model.Product;
import com.jml.mybatis.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> getAll() {
        return productMapper.listAll();
    }

    @Override
    public Product getProductById(long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public Product insert(Product product) {
        productMapper.insert(product);
        return product;
    }
}
