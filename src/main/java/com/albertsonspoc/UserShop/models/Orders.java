package com.albertsonspoc.UserShop.models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private int orderId;
    private Integer userId;
    private Integer productId;
    private int quantity;
    private Double pricePerUnit;
    private Integer addressId;
    private String orderStatus;
    private Date estimatedTimeArrival;
    private Date deliveredDate;
    private Date createdAt;
    private Date modifiedAt;
    private Integer modifiedBy;

    public Orders(){

    }

    public Orders(int orderId, Integer userId, Integer productId, int quantity, Double pricePerUnit, Integer addressId, String orderStatus, Integer modifiedBy) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.addressId = addressId;
        this.orderStatus = orderStatus;
        this.modifiedBy = modifiedBy;
    }

    public Integer getId() { return id;}

    public void setId(Integer id) {this.id = id;}

    public int getOrderId() {return orderId;}

    public void setOrderId(int orderId) {this.orderId = orderId;}

    public Integer getUserId() {return userId;}

    public void setUserId(Integer userId) {this.userId = userId;}

    public Integer getProductId() {return productId;}

    public void setProductId(Integer productId) {this.productId = productId;}

    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) {this.quantity = quantity;}

    public Double getPricePerUnit() {return pricePerUnit;}

    public void setPricePerUnit(Double pricePerUnit) {this.pricePerUnit = pricePerUnit;}

    public Integer getAddressId() {return addressId;}

    public void setAddressId(Integer addressId) {this.addressId = addressId;}

    public String getOrderStatus() {return orderStatus;}

    public void setOrderStatus(String orderStatus) {this.orderStatus = orderStatus;}

    public Date getCreatedAt() {return createdAt;}

    public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}

    public Date getModifiedAt() {return modifiedAt;}

    public void setModifiedAt(Date modifiedAt) {this.modifiedAt = modifiedAt;}

    public Integer getModifiedBy() {return modifiedBy;}

    public void setModifiedBy(Integer modifiedBy) {this.modifiedBy = modifiedBy;}

    public Date getEstimatedTimeArrival() {return estimatedTimeArrival;}

    public void setEstimatedTimeArrival(Date estimatedTimeArrival) {this.estimatedTimeArrival = estimatedTimeArrival;}

    public Date getDeliveredDate() {return deliveredDate;}

    public void setDeliveredDate(Date deliveredDate) {this.deliveredDate = deliveredDate;}

    @PrePersist
    public void prePersist() {
        Calendar c = Calendar.getInstance();
        setCreatedAt(c.getTime());
        setModifiedAt(c.getTime());
        c.add(Calendar.DATE,7);
        setEstimatedTimeArrival(c.getTime());
    }

    @PreUpdate
    public void preUpdate() {
        setModifiedAt(new Date());
    }

    @PostUpdate
    public void postUpdate(){
        setModifiedBy(getUserId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders order = (Orders) o;
        return orderId == order.orderId && quantity == order.quantity && id.equals(order.id) && userId.equals(order.userId) && productId.equals(order.productId) && pricePerUnit.equals(order.pricePerUnit) && addressId.equals(order.addressId) && orderStatus.equals(order.orderStatus) && estimatedTimeArrival.equals(order.estimatedTimeArrival) && Objects.equals(deliveredDate, order.deliveredDate) && createdAt.equals(order.createdAt) && modifiedAt.equals(order.modifiedAt) && modifiedBy.equals(order.modifiedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, userId, productId, quantity, pricePerUnit, addressId, orderStatus, estimatedTimeArrival, deliveredDate, createdAt, modifiedAt, modifiedBy);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", addressId=" + addressId +
                ", orderStatus='" + orderStatus + '\'' +
                ", estimatedTimeArrival=" + estimatedTimeArrival +
                ", deliveredDate=" + deliveredDate +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", modifiedBy=" + modifiedBy +
                '}';
    }
}
