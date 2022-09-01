package com.albertsonspoc.UserShop.services;

import com.albertsonspoc.UserShop.models.Status;
import com.albertsonspoc.UserShop.models.User;


import java.util.List;

public interface UserService{

    //registering the user
    public Status registerUser(User user);

    //this is just finding all the registered user from the UserRepository using JpaRepository
    List<User> findAll();
    User findByUserName(String username) throws Exception;
    User updateProfile(User user);
}
