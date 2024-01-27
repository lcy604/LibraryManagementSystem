package org.andy.librarymanagementsystem.repository.impl;

import org.andy.librarymanagementsystem.entity.User;
import org.andy.librarymanagementsystem.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class FileUserRepositoryImplement implements UserRepository {
    @Override
    public boolean addUser(User user) {
        // TODO: Add your code here
        throw new UnsupportedOperationException("someMethod is not yet implemented.");
    }
    @Override
    public boolean isValidLogin(String username, String password) {
        // TODO: Add your code here
        throw new UnsupportedOperationException("someMethod is not yet implemented.");
    }
    @Override
    public User findUser(String username) {
        // TODO: Add your code here
        throw new UnsupportedOperationException("someMethod is not yet implemented.");
    }
}
