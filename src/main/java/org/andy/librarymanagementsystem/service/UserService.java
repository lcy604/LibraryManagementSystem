package org.andy.librarymanagementsystem.service;

import org.andy.librarymanagementsystem.entity.User;
import org.andy.librarymanagementsystem.repository.UserRepository;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(User user) {
        return userRepository.addUser(user);
    }

    public boolean loginUser(String username, String password) {
        return userRepository.isValidLogin(username, password);
    }
}
