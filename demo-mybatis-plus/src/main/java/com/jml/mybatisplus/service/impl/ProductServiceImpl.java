package com.jml.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jml.mybatisplus.mapper.ProductMapper;
import com.jml.mybatisplus.model.Product;
import com.jml.mybatisplus.service.IProductService;
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
    public int saveProduct(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public Product findProductById(long id) {
        return productMapper.selectById(id);
    }

    @Override
    public Product findProductById2(long id) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);

        return productMapper.selectOne(wrapper);
    }

    @Override
    public List<Product> findAllProduct() {
        return productMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public int deleteProductById(long id) {
        return productMapper.deleteById(id);
    }

    @Override
    public int updateProductById(Product product) {
        return productMapper.updateById(product);
    }

    @Override
    public List<Product> findProductByGtId(long gtId) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.gt("id",gtId);
        return productMapper.selectList(wrapper);
    }

    @Override
    public IPage<Product> findProductPageByGtId(Page page, long gtId) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.gt("id",gtId);
        return productMapper.selectPage(page,wrapper);
    }
}
