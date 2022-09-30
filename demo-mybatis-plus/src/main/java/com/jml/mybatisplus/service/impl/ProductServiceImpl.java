package com.jml.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jml.mybatisplus.mapper.ProductMapper;
import com.jml.mybatisplus.model.Product;
import com.jml.mybatisplus.service.IProductService;
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

    @Override
    public List<Product> getProductPageByMyBatisPlusList(Integer pageNumber, Integer pageSize) {
        //封装分页信息，第一个参数页码值、第二个参数每页显示数量
        Page<Product> page= new Page<>(pageNumber,pageSize);
        IPage<Product> iPage = productMapper.selectPage(page,null);
        return iPage.getRecords();
    }
}
