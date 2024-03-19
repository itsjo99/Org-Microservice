package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Request.UserRequest;

import java.util.List;

public interface UserService {
    long addUser(UserRequest request);

    List<User> getAllUsers();

    User editUser(Long userId, String userName, String phone, String orgName);

    void deleteUser(Long userId);
}
