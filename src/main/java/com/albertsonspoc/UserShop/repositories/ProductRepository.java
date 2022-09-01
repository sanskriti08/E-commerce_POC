package com.albertsonspoc.UserShop.repositories;



import com.albertsonspoc.UserShop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



import com.albertsonspoc.UserShop.models.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    public Product findById(int productId);
}