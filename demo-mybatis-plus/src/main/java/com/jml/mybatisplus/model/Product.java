package com.jml.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@TableName("product_tb")//实体类和表名不一致
@Data
@ToString
public class Product {

    @TableId(value = "id", type = IdType.AUTO)//插入数据后让自增id回写(很实用)
    private Long id;

    @TableField("product_id")//实体类属性和表的字段名不一致
    private Long productId;

    private Integer status;

    private Long totalAmount;

}