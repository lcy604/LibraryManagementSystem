package org.andy.librarymanagementsystem.repository.impl;

import org.andy.librarymanagementsystem.entity.User;
import org.andy.librarymanagementsystem.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class InMemoryUserRepositoryImplement implements UserRepository {
    private Map<String, User> users = new HashMap<>();
    @Override
    public boolean addUser(User user) {
        if (!users.containsKey(user.getUsername())) {
            users.put(user.getUsername(), user);
            return true;
        }
        return false;
    }
    @Override
    public boolean isValidLogin(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            return user.getPassword().equals(password);
        }
        return false;
    }
    @Override
    public User findUser(String username) {
        return users.get(username);
    }
}
