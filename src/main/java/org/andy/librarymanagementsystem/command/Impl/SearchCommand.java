package org.andy.librarymanagementsystem.command.Impl;

import org.andy.librarymanagementsystem.command.BaseCommand;
import org.andy.librarymanagementsystem.command.Command;
import org.andy.librarymanagementsystem.entity.Book;
import org.andy.librarymanagementsystem.entity.User;
import org.andy.librarymanagementsystem.service.BookService;
import org.andy.librarymanagementsystem.service.BorrowRecordService;
import org.andy.librarymanagementsystem.service.UserService;

import java.util.Map;

/**
 * @author Andy
 * @created 2024/1/17/017
 */
public class SearchCommand extends BaseCommand {
    @Override
    public void execute(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        // Check if there is a currently logged-in user
        User currentUser = userService.getLoginUser();

        if (currentUser != null) {
            // Check if the command has the correct format
            String title = tokens[1];
            String author = tokens[2];

            // Search for books using the BookService
            Book book = bookService.getBook(title, author);

            if (book == null) {
                System.out.println("No matching books found.");
            } else {
                System.out.println(book);
            }
        } else {
            System.out.println("Please log in to perform a search.");
        }
    }

    @Override
    public boolean validate(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        if (tokens.length == 3) {
            return true;
        } else {
            System.out.println("Invalid command format. Usage: search title author");
            return false;
        }

    }
}
