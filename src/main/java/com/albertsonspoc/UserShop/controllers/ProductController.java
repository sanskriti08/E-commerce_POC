package com.albertsonspoc.UserShop.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.albertsonspoc.UserShop.models.Product;
import com.albertsonspoc.UserShop.services.ProductService;



@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/details")
    public List<Product> productDetails() {
    	System.out.println("Here at product details");
        List<Product> products = productService.findAll();
        System.out.println("Here at product details");
        return products;
    }

    @GetMapping("/product/{id}")
    public  Product  productDetailsById(@PathVariable("id")int id) {
        Product productItem = productService.findById(id);

        return  productItem;
    }
}