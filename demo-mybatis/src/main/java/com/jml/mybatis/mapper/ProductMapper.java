package com.jml.mybatis.mapper;

import com.jml.mybatis.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<Product> listAll();

    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> getProductPageByLimitList(@Param("pageNow") Integer pageNow, @Param("pageSize") Integer pageSize);

    List<Product> getProductPageByRowBoundsList(RowBounds rowBounds);

    List<Product> getProductPageByPageHelperList();
}