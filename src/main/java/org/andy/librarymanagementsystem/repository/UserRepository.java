package org.andy.librarymanagementsystem.repository;

import org.andy.librarymanagementsystem.entity.User;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public interface UserRepository {
    boolean addUser(User user);

    boolean isValidLogin(String username, String password);
}
