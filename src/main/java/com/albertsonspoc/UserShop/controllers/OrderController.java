package com.albertsonspoc.UserShop.controllers;

import com.albertsonspoc.UserShop.dto.OrderItem;
import com.albertsonspoc.UserShop.models.Orders;
import com.albertsonspoc.UserShop.models.Status;
import com.albertsonspoc.UserShop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/orders/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderItem> getOrders(@PathVariable("userName") String userName){
        return orderService.getOrders(userName);
    }

    @PostMapping(value = "/createOrder")
    public Status placeOrder(@RequestParam("userName") String userName){
        return orderService.placeOrder(userName);
    }
}
