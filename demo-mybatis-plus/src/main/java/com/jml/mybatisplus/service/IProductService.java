package com.jml.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jml.mybatisplus.model.Product;

import java.sql.Wrapper;
import java.util.List;

public interface IProductService {

    /**
     * 保存Product
     *
     * @param product
     * @return
     */
    int saveProduct(Product product);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    Product findProductById(long id);
    Product findProductById2(long id);
    /**
     * 查找全部
     *
     * @return
     */
    List<Product> findAllProduct();

    /**
     * 删除一个
     *
     * @param id
     * @return
     */
    int deleteProductById(long id);

    /**
     * 修改一个
     *
     * @param product
     * @return
     */
    int updateProductById(Product product);

    /**
     * id大于多少
     *
     * @param gtId
     * @return
     */
    List<Product> findProductByGtId(long gtId);


    IPage<Product> findProductPageByGtId(Page page, long gtId);
}
