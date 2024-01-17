package org.andy.librarymanagementsystem.command.Impl;

import org.andy.librarymanagementsystem.BookKeyUtil;
import org.andy.librarymanagementsystem.command.BaseCommand;
import org.andy.librarymanagementsystem.command.Command;
import org.andy.librarymanagementsystem.entity.User;
import org.andy.librarymanagementsystem.service.BookService;
import org.andy.librarymanagementsystem.service.BorrowRecordService;
import org.andy.librarymanagementsystem.service.UserService;

/**
 * @author Andy
 * @created 2024/1/17/017
 */
public class ReturnCommand  extends BaseCommand {
    @Override
    public void execute(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        // Check if there is a currently logged-in user
        User currentUser = userService.getLoginUser();

        if (currentUser != null && currentUser instanceof User) {
            // Check if the current user is a regular user

            String title = tokens[1];
            String author = tokens[2];

            // Attempt to return the book
            boolean returned = borrowRecordService.returnBook(currentUser.getUsername(), BookKeyUtil.generateBookKey(title, author));
            if (returned) {
                bookService.returnBook(title, author);
                System.out.println("Book \"" + title + "\" by " + author + " returned successfully.");
            } else {
                System.out.println("Cannot return book \"" + title + "\" by " + author + ". It may not be borrowed or the user does not have a valid borrow record for it.");
            }
        } else {
            System.out.println("Only regular users can return books. Please log in as a regular user.");
        }
    }

    @Override
    public boolean validate(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        if (tokens.length == 3) {
            return true;
        } else {
            System.out.println("Invalid command format. Usage: return title author");
            return false;
        }
    }
}