package com.albertsonspoc.UserShop.models;



import java.util.Date;


import javax.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    int id;
    String name;
    String description;
    String image;
    Double price;
    private Date createdAt;
    private Date modifiedAt;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private Date lastLoginAt;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }




    @PrePersist
    public void prePersist() {
        Date now = new Date();
        setCreatedAt(now);
        setModifiedAt(now);
        setLastLoginAt(now);
    }
    @PreUpdate
    public void preUpdate() {
        setModifiedAt(new Date());



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



    public Date getLastLoginAt() {
        return lastLoginAt;
    }



    public void setLastLoginAt(Date lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
                + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", lastLoginAt=" + lastLoginAt + "]";
    }



}