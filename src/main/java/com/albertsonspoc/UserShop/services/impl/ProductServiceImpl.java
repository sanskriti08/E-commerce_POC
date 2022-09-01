package com.albertsonspoc.UserShop.services.impl;



import java.util.List;
import java.util.Optional;


import com.albertsonspoc.UserShop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.albertsonspoc.UserShop.models.Product;
import com.albertsonspoc.UserShop.services.ProductService;



@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }
}
//@query(query dalo)
//public method()
//{
//
//}