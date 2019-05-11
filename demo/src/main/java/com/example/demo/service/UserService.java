package com.example.demo.service;

import com.example.demo.model.UserDetails;

import java.util.List;

/**
 * Created by Ghufya on 28/04/2019.
 */
public interface UserService {
    public List getUserDetails();
    public UserDetails findDetails(int id);
    public long insert(UserDetails userDetails);
}
