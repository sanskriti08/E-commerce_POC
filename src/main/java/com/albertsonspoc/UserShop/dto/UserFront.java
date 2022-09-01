package com.albertsonspoc.UserShop.dto;

import javax.persistence.*;
import java.util.Objects;

//basically dto classes are designed for those fields which we are expecting from frontend.
@Entity
public class UserFront {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fullName;
    private String userName;
    private String email;
    private String phone;
    private String password;
    private String address;


    public UserFront(){
    }

    public UserFront(String fullName, String userName, String email, String phone, String password, String address) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address=address;

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
        UserFront userFront = (UserFront) o;
        return id == userFront.id && fullName.equals(userFront.fullName) && userName.equals(userFront.userName) && email.equals(userFront.email) && phone.equals(userFront.phone) && password.equals(userFront.password) && address.equals(userFront.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, userName, email, phone, password,address);
    }

    @Override
    public String toString() {
        return "UserFront{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

