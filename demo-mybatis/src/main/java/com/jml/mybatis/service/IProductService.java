package com.jml.mybatis.service;

import com.jml.mybatis.model.Product;

import java.util.List;

public interface IProductService {

    /**
     * 查询所有
     * @return
     */
    List<Product> getAll();

    /**
     * 根据产品代码查询
     * @param id
     * @return
     */
    Product getProductById(long id);

    /**
     * 保存产品
     * @param product
     * @return
     */
    Product insert(Product product);


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

}
