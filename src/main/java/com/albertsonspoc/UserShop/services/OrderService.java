package com.albertsonspoc.UserShop.services;

import com.albertsonspoc.UserShop.dto.OrderItem;
import com.albertsonspoc.UserShop.models.*;
import com.albertsonspoc.UserShop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CartRepository cartRepository;

    public List<OrderItem> getOrders(String userName){
        List<Orders> orders = orderRepository.findByUserId(userRepository.findByUserName(userName).getId());
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        for(Orders order : orders){
            Product product = productRepository.findById(order.getProductId()).get();
            Address address = addressRepository.findById(order.getAddressId()).get();
            User user = userRepository.findById(order.getUserId()).get();
            orderItems.add(new OrderItem(order, product, user.getUserName(), address));
        }
        return orderItems;
    }

    public Status placeOrder(String userName){
        Orders lastOrder = orderRepository.findFirstByOrderByIdDesc();
        int orderId;
        if(lastOrder != null) orderId = lastOrder.getOrderId() + 1;
        else orderId = 1;
        User user = userRepository.findByUserName(userName);
        List<Cart> cartItems = cartRepository.findByUser(user);
        for(Cart item : cartItems){
            Product product = item.getProduct();
            Orders order = new Orders(orderId, user.getId(),product.getId(), item.getQuantity(), product.getPrice(), addressRepository.findByUserId(user.getId()).getId(), "Ordered", user.getId());
            orderRepository.save(order);
        }
        return Status.SUCCESS;
    }

}