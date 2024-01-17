package org.andy.librarymanagementsystem.command.Impl;

import org.andy.librarymanagementsystem.command.BaseCommand;
import org.andy.librarymanagementsystem.command.Command;
import org.andy.librarymanagementsystem.entity.Admin;
import org.andy.librarymanagementsystem.entity.User;
import org.andy.librarymanagementsystem.service.BookService;
import org.andy.librarymanagementsystem.service.BorrowRecordService;
import org.andy.librarymanagementsystem.service.UserService;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class RegisterCommand  extends BaseCommand {

    @Override
    public void execute(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        String role = tokens[1].toLowerCase();
        String username = tokens[2];
        String password = tokens[3];

        if (role.equals("admin")) {
            Admin admin = new Admin(username, password);
            if (userService.registerUser(admin)) {
                System.out.println("Admin " + username + " successfully registered.");
            } else {
                System.out.println("Admin " + username + " already exists.");
            }
        } else if (role.equals("user")) {
            User user = new User(username, password);
            if (userService.registerUser(user)) {
                System.out.println("User " + username + " successfully registered.");
            } else {
                System.out.println("User " + username + " already exists.");
            }
        } else {
            System.out.println("Invalid role. Please use 'admin' or 'user'.");
        }

    }

    @Override
    public boolean validate(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        if (tokens.length == 4) {
            return true;
        } else {
            System.out.println("Invalid command format. Usage: register [admin/user] username password");
            return false;
        }

    }
}
