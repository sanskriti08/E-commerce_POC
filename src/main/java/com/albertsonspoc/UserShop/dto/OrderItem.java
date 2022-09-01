package com.albertsonspoc.UserShop.dto;

import com.albertsonspoc.UserShop.models.Address;
import com.albertsonspoc.UserShop.models.Orders;
import com.albertsonspoc.UserShop.models.Product;
import com.albertsonspoc.UserShop.models.User;

import java.util.Date;

public class OrderItem {
    private Integer id;
    private int orderId;
    private int quantity;
    private Double pricePerUnit;
    private String orderStatus;
    private Date createdAt;
    private Date modifiedAt;
    private Integer modifiedBy;
    private Product product;
    private String userName;
    private Address address;
    private Double totalAmount;
    private Date estimatedTimeArrival;
    private Date deliveredDate;

    public OrderItem(){

    }

    public OrderItem(Orders order, Product product, String userName, Address address) {
        this.id = order.getId();
        this.orderId = order.getOrderId();
        this.quantity = order.getQuantity();
        this.pricePerUnit = order.getPricePerUnit();
        this.orderStatus = order.getOrderStatus();
        this.createdAt = order.getCreatedAt();
        this.modifiedAt = order.getModifiedAt();
        this.modifiedBy = order.getModifiedBy();
        this.estimatedTimeArrival = order.getEstimatedTimeArrival();
        this.deliveredDate = order.getDeliveredDate();
        this.totalAmount = order.getPricePerUnit() * order.getQuantity();
        this.product = product;
        this.userName = userName;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getEstimatedTimeArrival() {
        return estimatedTimeArrival;
    }

    public void setEstimatedTimeArrival(Date estimatedTimeArrival) {
        this.estimatedTimeArrival = estimatedTimeArrival;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }
}
