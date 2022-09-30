package com.jml.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jml.mybatisplus.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> getProductPageByLimitList(@Param("pageNow") Integer pageNow, @Param("pageSize") Integer pageSize);

    List<Product> getProductPageByRowBoundsList(RowBounds rowBounds);

    List<Product> getProductPageByPageHelperList();

}