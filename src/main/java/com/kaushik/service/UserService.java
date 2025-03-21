package com.kaushik.service;

import com.kaushik.exception.UserException;
import com.kaushik.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id) throws UserException;
    List<User> getAllUsers();
    void deleteUser(Long id);

    User updateUser(Long id,User user) throws UserException;

}
