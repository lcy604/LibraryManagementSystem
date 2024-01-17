package org.andy.librarymanagementsystem.service;

import org.andy.librarymanagementsystem.entity.User;
import org.andy.librarymanagementsystem.repository.UserRepository;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class UserService {
    private UserRepository userRepository;

    private User loginUser;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(User user) {
        return userRepository.addUser(user);
    }

    public boolean loginUser(String username, String password) {
        boolean validLogin = userRepository.isValidLogin(username, password);
        if (validLogin){
            loginUser =  userRepository.findUser(username);
        }
        return validLogin;
    }

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    public User findUser(String username){
        return userRepository.findUser(username);
    }
}
