package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dao.UserDao;
import com.example.demo.model.UserDetails;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List getUserDetails() {
        return userDao.getUserDetails();
    }

    @Override
    public UserDetails findDetails(int id) {
        return userDao.find(id);
    }

    @Override
    public long insert(UserDetails userDetails) {
        return userDao.insert(userDetails);
    }

}
