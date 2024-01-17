package org.andy.librarymanagementsystem.entity;
/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class Admin extends User {

    private boolean isAdmin = true;

    public Admin(String username, String password) {
        super(username, password);
    }
}
