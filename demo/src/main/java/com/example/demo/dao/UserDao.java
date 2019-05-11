package com.example.demo.dao;

import com.example.demo.model.UserDetails;

import java.util.List;

public interface UserDao {

    public List getUserDetails() ;
    public long insert(UserDetails user);
    public UserDetails find(int id) ;

}
