package com.jml.mybatisplus.controller;

import com.jml.mybatisplus.model.Product;
import com.jml.mybatisplus.service.IProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = {"/get/{id}"},method = {RequestMethod.GET})
    public Product getProductById(@PathVariable("id") long id){
        return productService.findProductById(id);
    }

}
