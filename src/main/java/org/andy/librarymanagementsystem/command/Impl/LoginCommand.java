package org.andy.librarymanagementsystem.command.Impl;

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
public class LoginCommand implements Command {

    @Override
    public void execute(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        if (tokens.length == 3) {
            String username = tokens[1];
            String password = tokens[2];

            if (userService.loginUser(username, password)) {
                if (userService.getLoginUser() instanceof Admin){
                    System.out.println("Admin " + username + " successfully logged in.");
                }else {
                    System.out.println("User " + username + " successfully logged in.");
                }

            } else {
                System.out.println("Invalid login credentials.");
            }
        } else {
            System.out.println("Invalid command format. Usage: login username password");
        }
    }
}
