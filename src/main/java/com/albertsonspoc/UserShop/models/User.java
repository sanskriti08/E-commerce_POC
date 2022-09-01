package com.albertsonspoc.UserShop.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

   private int id;

    private String fullName;
    private String userName;
    private String email;
    private String phone;
    private String password;
    private Date createdAt;
    private Date modifiedAt;
    private Date lastLoginAt;
    private String address;

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

    public User(){
    }

    public User(String fullName, String userName, String email, String phone, String password, Date createdAt, Date modifiedAt, Date lastLoginAt, String address) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.lastLoginAt = lastLoginAt;
        this.address= address;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && fullName.equals(user.fullName) && userName.equals(user.userName) && email.equals(user.email) && phone.equals(user.phone) && password.equals(user.password) && createdAt.equals(user.createdAt) && modifiedAt.equals(user.modifiedAt) && lastLoginAt.equals(user.lastLoginAt) && address.equals(user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, userName, email, phone, password, createdAt, modifiedAt, lastLoginAt,address);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", lastLoginAt=" + lastLoginAt +
                ", address='" + address + '\'' +
                '}';
    }
}
