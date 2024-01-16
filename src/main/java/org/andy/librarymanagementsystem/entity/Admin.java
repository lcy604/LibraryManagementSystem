package org.andy.librarymanagementsystem.entity;

public class Admin extends User {

    private boolean isAdmin = true;

    Admin(String username, String password) {
        super(username, password);
    }
}
