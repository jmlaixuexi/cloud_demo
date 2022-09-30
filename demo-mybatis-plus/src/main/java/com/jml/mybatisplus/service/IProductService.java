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


    /**
     * 使用原生Limit关键字进行分页
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<Product> getProductPageByLimitList(Integer pageNumber,Integer pageSize);

    /**
     * 借助MyBabtis提供的RowBounds进行分页查询
     * RowBounds它是在SQL执行的结果进行截取分页的，所以不适合大量数据的截取和分页，它适合在查询较少的结果集当中使用。
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<Product> getProductPageByRowBoundsList(Integer pageNumber,Integer pageSize);

    /**
     * 借助MyBatis提供的第三方PageHelper分页插件
     * 在MyBatis中配置了分页拦截器（PageInterceptor），就是在执行相关的Sql之前会做一些拦截的操作，
     * 这里通过调用startPage的方法，其实就是在查询getProductPageByPageHelperList之前会自动加上limit；
     * 这里通过setLocalPage方法，将分页信息保存在当前之后线程当中，查询方法与之处于同一个线程，
     * 共享ThreadLocal当中的数据，最后将getProductPageByPageHelperList查询好的数据结果放到PageInfo当中即可。
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<Product> getProductPageByPageHelperList(Integer pageNumber,Integer pageSize);

    /**
     * 借助MyBatis-Plus拦截器进行分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<Product> getProductPageByMyBatisPlusList(Integer pageNumber,Integer pageSize);
}
