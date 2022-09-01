package com.albertsonspoc.UserShop.services.impl;


import com.albertsonspoc.UserShop.models.Status;
import com.albertsonspoc.UserShop.models.User;
import com.albertsonspoc.UserShop.repositories.UserRepository;
import com.albertsonspoc.UserShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Status registerUser(User user) {
        userRepository.save(user);
        return Status.SUCCESS;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public User updateProfile(User user) {
        return userRepository.save(user);
    }
    @Override
    public User findByUserName(String username){

        return userRepository.findByUserName(username);
    }
}
