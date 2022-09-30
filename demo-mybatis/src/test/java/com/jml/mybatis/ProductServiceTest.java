package com.jml.mybatis;

import com.jml.mybatis.model.Product;
import com.jml.mybatis.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
//此处classes内的内容是@SpringBootApplication入口
@SpringBootTest(classes = {MybatisApplicaction.class})
public class ProductServiceTest {

    @Autowired
    IProductService productService;

    @Test
    public void testGetProductPageByLimitList() {
        List<Product> list = new ArrayList<>();

        int num = 1;
        while (num < 10) {

            list = productService.getProductPageByLimitList(num, 20);

            if(!CollectionUtils.isEmpty(list) && list.size()==20){
                num++;
            }else {
                num = 11;
            }

            System.out.println(list);
        }
    }


    @Test
    public void testGetProductPageByRowBoundsList() {
        List<Product> list = new ArrayList<>();

        int num = 1;
        while (num < 10) {

            list = productService.getProductPageByRowBoundsList(num, 20);

            if(!CollectionUtils.isEmpty(list) && list.size()==20){
                num++;
            }else {
                num = 11;
            }

            System.out.println(list);
        }
    }


    @Test
    public void testGetProductPageByPageHelperList() {
        List<Product> list = new ArrayList<>();

        int num = 1;
        while (num < 10) {

            list = productService.getProductPageByPageHelperList(num, 20);

            if(!CollectionUtils.isEmpty(list) && list.size()==20){
                num++;
            }else {
                num = 11;
            }

            System.out.println(list);
        }
    }
}
