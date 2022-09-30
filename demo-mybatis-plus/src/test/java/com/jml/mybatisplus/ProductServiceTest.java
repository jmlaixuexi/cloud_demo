package com.jml.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jml.mybatisplus.model.Product;
import com.jml.mybatisplus.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
//此处classes内的内容是@SpringBootApplication入口
@SpringBootTest(classes = {MybatisplusApplication.class})
public class ProductServiceTest {

    @Autowired
    IProductService productService;

    @Test
    public void testSaveProduct(){
        Random r=new Random();
        long id = r.nextLong();

        Product product = new Product();
        product.setId(id);
        product.setProductId(id);
        product.setStatus(0);
        product.setTotalAmount(100L);

        int num =  productService.saveProduct(product);

        System.out.println(num);
    }

    @Test
    public void testBatchSaveProduct(){
        int num = 0;
        while (num < 100) {
            testSaveProduct2();
            num++;
        }
    }
    @Test
    public void testSaveProduct2(){
        Random r=new Random();
        long id = r.nextLong();

        Product product = new Product();
        product.setProductId(id);
        product.setStatus(0);
        product.setTotalAmount(100L);

        int num =  productService.saveProduct(product);

        System.out.println(product);
    }

    @Test
    public void testFindProductById(){
        long id = 1L;

        Product product = productService.findProductById(id);

        System.out.println(product);
    }

    @Test
    public void testFindProductById2(){
        long id = 1L;
        Product product = productService.findProductById2(id);
        System.out.println(product);
    }

    @Test
    public void testFindAllProduct(){
        List<Product> list = productService.findAllProduct();
        System.out.println(list);
    }

    @Test
    public void testDeleteProductById(){
        long id = -3947544784963782482L;
        int count = productService.deleteProductById(id);
        System.out.println(count);
    }

    @Test
    public void testUpdateProductById(){
        long id = 1L;

        Product product = new Product();
        product.setId(id);
        product.setProductId(id);
        product.setStatus(0);
        product.setTotalAmount(200L);

        int num =  productService.updateProductById(product);

        System.out.println(num);
    }


    @Test
    public void testFindProductByGtId(){
        long id = 1L;
        List<Product> list = productService.findProductByGtId(id);
        System.out.println(list);
    }

    @Test
    public void testfindProductPageByGtId(){
        //封装分页信息，第一个参数页码值、第二个参数每页显示数量
        Page<Product> pages = new Page<Product>(1, 10);
        //进行分页查询
        IPage<Product> iPage = productService.findProductPageByGtId(pages,1L);
        //获取分页查询记录
        List<Product> data = iPage.getRecords();
        //获取总记录
        long count = iPage.getTotal();

        System.out.println(data);
    }


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

    @Test
    public void testGetProductPageByMyBatisPlusList() {
        List<Product> list = new ArrayList<>();

        int num = 1;
        while (num < 10) {

            list = productService.getProductPageByMyBatisPlusList(num, 20);

            if(!CollectionUtils.isEmpty(list) &&list.size()==20){
                num++;
            }else {
                num = 11;
            }

            System.out.println(list);
        }
    }
}
