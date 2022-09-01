package com.albertsonspoc.UserShop.services;

import com.albertsonspoc.UserShop.models.Cart;
import com.albertsonspoc.UserShop.models.Product;
import org.springframework.stereotype.Service;

@Service
public interface CartService {

	void addToCart(int productId,String userName);
}
