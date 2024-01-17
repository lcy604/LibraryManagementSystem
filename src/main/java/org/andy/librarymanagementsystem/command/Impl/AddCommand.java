package org.andy.librarymanagementsystem.command.Impl;

import org.andy.librarymanagementsystem.command.Command;
import org.andy.librarymanagementsystem.entity.Admin;
import org.andy.librarymanagementsystem.entity.Book;
import org.andy.librarymanagementsystem.entity.User;
import org.andy.librarymanagementsystem.service.BookService;
import org.andy.librarymanagementsystem.service.BorrowRecordService;
import org.andy.librarymanagementsystem.service.UserService;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class AddCommand implements Command {

    @Override
    public void execute(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        User currentUser = userService.getLoginUser();

        if (currentUser != null && currentUser instanceof Admin) {
            // Check if the current user is an admin
            if (tokens.length == 4) {
                String title = tokens[1];
                String author = tokens[2];
                int totalInventory;

                try {
                    totalInventory = Integer.parseInt(tokens[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid command format. Inventory should be an integer.");
                    return;
                }

                // Attempt to add the book
                Book newBook = bookService.addBook(title, author, totalInventory);
                System.out.println("Book \"" + title + "\" by " + author + " added successfully, inventory: " + newBook.getCurrentInventory() + ".");
            } else {
                System.out.println("Invalid command format. Usage: add title author totalInventory");
            }
        } else {
            System.out.println("Only administrators can add books. Please log in as an admin.");
        }
    }
}