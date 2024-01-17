package org.andy.librarymanagementsystem.command.Impl;

import org.andy.librarymanagementsystem.command.Command;
import org.andy.librarymanagementsystem.entity.Book;
import org.andy.librarymanagementsystem.entity.User;
import org.andy.librarymanagementsystem.service.BookService;
import org.andy.librarymanagementsystem.service.BorrowRecordService;
import org.andy.librarymanagementsystem.service.UserService;

import java.util.Map;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class ListCommand implements Command {

    @Override
    public void execute(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        User currentUser = userService.getLoginUser();

        if (currentUser != null) {
            // Display the list of books using the BookService
            Map<String, Book> allBooks = bookService.getAllBooks();

            if (allBooks.isEmpty()) {
                System.out.println("No books available in the library.");
            } else {
                System.out.println("Book List:");
                for (Book book : allBooks.values()) {
                    System.out.println(book);
                }
            }
        } else {
            System.out.println("Please log in to view the list of books.");
        }
    }
}