package com.albertsonspoc.UserShop.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private String address;
    private Date createdAt;
    private Date modifiedAt;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getUserId() {return userId;}

    public void setUserId(Integer userId) {this.userId = userId;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public Date getCreatedAt() {return createdAt;}

    public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}

    public Date getModifiedAt() {return modifiedAt;}

    public void setModifiedAt(Date modifiedAt) {this.modifiedAt = modifiedAt;}

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        setCreatedAt(now);
        setModifiedAt(now);
    }

    @PreUpdate
    public void preUpdate() {
        setModifiedAt(new Date());
    }
}
