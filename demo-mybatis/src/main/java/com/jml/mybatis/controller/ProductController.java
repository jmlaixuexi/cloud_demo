package com.jml.mybatis.controller;

import com.jml.mybatis.model.Product;
import com.jml.mybatis.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping(value = {"/all"},method = {RequestMethod.GET})
    public List<Product> getAll(){
        return productService.getAll();
    }
    @RequestMapping(value = {"/get/{id}"},method = {RequestMethod.GET})
    public Product getProductById(@PathVariable("id") long id){
        return productService.getProductById(id);
    }
    @RequestMapping(value = {"/add"},method = {RequestMethod.GET})
    public Product insert(){
        Product product = new Product();
        product.setId(1L);
        product.setProductId(1L);
        product.setStatus(0);
        product.setTotalAmount(100L);
        return productService.insert(product);
    }
}
