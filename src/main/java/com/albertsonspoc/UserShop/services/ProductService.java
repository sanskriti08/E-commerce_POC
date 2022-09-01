package com.albertsonspoc.UserShop.services;

import java.util.List;

import com.albertsonspoc.UserShop.models.Product;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);



}