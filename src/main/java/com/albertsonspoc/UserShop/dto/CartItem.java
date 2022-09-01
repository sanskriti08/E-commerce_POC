package com.albertsonspoc.UserShop.dto;

public class CartItem {
     String productName;
     Double price;
     int quantity;
     int id;
     

    public CartItem() {
    }

    public CartItem(String productName, Double price, int quantity, int id) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
