package com.jml.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jml.mybatis.mapper.ProductMapper;
import com.jml.mybatis.model.Product;
import com.jml.mybatis.service.IProductService;
import org.apache.ibatis.session.RowBounds;
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

    @Override
    public List<Product> getProductPageByLimitList(Integer pageNumber, Integer pageSize) {
        Integer pageNow = (pageNumber - 1) * pageSize;
        return productMapper.getProductPageByLimitList(pageNow,pageSize);
    }

    @Override
    public List<Product> getProductPageByRowBoundsList(Integer pageNumber, Integer pageSize) {
        Integer pageNow = (pageNumber - 1) * pageSize;
        RowBounds rowBounds = new RowBounds(pageNow,pageSize);
        return productMapper.getProductPageByRowBoundsList(rowBounds);
    }

    @Override
    public List<Product> getProductPageByPageHelperList(Integer pageNumber, Integer pageSize) {
        Integer pageNow = (pageNumber - 1) * pageSize;
        PageHelper.startPage(pageNumber, pageSize);
        List<Product> productList = productMapper.getProductPageByPageHelperList();
        PageInfo<Product> productPageInfo = new PageInfo<>(productList);
        return productPageInfo.getList();
    }
}
