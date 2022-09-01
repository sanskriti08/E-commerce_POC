package com.albertsonspoc.UserShop.controllers;

import com.albertsonspoc.UserShop.dto.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.ArrayUtils;

import com.albertsonspoc.UserShop.models.Cart;
import com.albertsonspoc.UserShop.models.Product;

import com.albertsonspoc.UserShop.services.ProductService;
import com.albertsonspoc.UserShop.services.impl.CartServiceImpl;

import java.util.List;

@RestController("/")
@CrossOrigin("*")
public class CartController {
    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private ProductService productService;
//pathvariable - xyz/{z}
    //reaquestparam - xyz
    //requestbody - pura object mang loo
    @GetMapping("/cart")
            public List<CartItem> getCartItem(@RequestParam("userName") String userName)
    {
        return cartService.getCartItem(userName);
    }
    @PostMapping("/cart/{id}")
    public  void changeCount(@RequestParam("increment") boolean incrementFlag ,@PathVariable("id") int id)
    {      System.out.println("hello richa");
        cartService.changeCount(incrementFlag,id);
    }
    @GetMapping("/cart/{id}")
    public Cart getCart(@PathVariable("id") int id)
    {
        Cart cart = cartService.getCartItem(id);
        return  cart;
    }
    @DeleteMapping("/cart/{id}")
    public  void remove(@PathVariable("id") int id )
    {
    cartService.remove(id);
    }

    @PostMapping("/cart")
    public void addToCart(@RequestParam("productId") int productId, @RequestParam("userName") String userName) {
        cartService.addToCart(productId, userName);
    }
}