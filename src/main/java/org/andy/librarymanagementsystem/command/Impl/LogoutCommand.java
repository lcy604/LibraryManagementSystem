package org.andy.librarymanagementsystem.command.Impl;

import org.andy.librarymanagementsystem.command.BaseCommand;
import org.andy.librarymanagementsystem.command.Command;
import org.andy.librarymanagementsystem.entity.User;
import org.andy.librarymanagementsystem.service.BookService;
import org.andy.librarymanagementsystem.service.BorrowRecordService;
import org.andy.librarymanagementsystem.service.UserService;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class LogoutCommand  extends BaseCommand {

    @Override
    public void execute(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        User currentUser = userService.getLoginUser();

        if (currentUser != null) {
            System.out.println(currentUser.getUsername() + " successfully logged out.");
            userService.setLoginUser(null); // Clear the current user
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    @Override
    public boolean validate(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        return true;
    }
}