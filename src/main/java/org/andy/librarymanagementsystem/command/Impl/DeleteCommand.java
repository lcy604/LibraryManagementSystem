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
public class DeleteCommand implements Command {

    @Override
    public void execute(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        User currentUser = userService.getLoginUser();

        if (currentUser != null && currentUser instanceof Admin) {
            // Check if the current user is an admin
            if (tokens.length == 3) {
                String title = tokens[1];
                String author = tokens[2];

                // Attempt to delete the book
                boolean deleted = bookService.deleteBook(title, author);

                if (deleted) {
                    System.out.println("Book \"" + title + "\" by " + author + " deleted successfully.");
                } else {
                    System.out.println("Cannot delete book \"" + title + "\" by " + author + ".");
                }
            } else {
                System.out.println("Invalid command format. Usage: delete title author");
            }
        } else {
            System.out.println("Only administrators can delete books. Please log in as an admin.");
        }
    }
}