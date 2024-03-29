package org.andy.librarymanagementsystem.command.Impl;

import org.andy.librarymanagementsystem.util.BookKeyUtil;
import org.andy.librarymanagementsystem.command.BaseCommand;
import org.andy.librarymanagementsystem.service.BookService;
import org.andy.librarymanagementsystem.service.BorrowRecordService;
import org.andy.librarymanagementsystem.service.UserService;

/**
 * @author Andy
 * @created 2024/1/17/017
 */
public class BorrowCommand  extends BaseCommand {
    @Override
    public void execute(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        String title = tokens[1];
        String author = tokens[2];

        if (bookService.borrowBook(title, author)) {
            String username = userService.getLoginUser().getUsername();
            borrowRecordService.borrowBook(username, BookKeyUtil.generateBookKey(bookService.getBook(title, author)), 1);
            System.out.println("Book \"" + title + "\" by " + author + " successfully borrowed.");
        } else {
            System.out.println("Failed to borrow the book. Check inventory or book availability.");
        }
    }

    @Override
    public boolean validate(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        if (tokens.length == 3) {
            return true;
        } else {
            System.out.println("Invalid command format. Usage: delete title author");
            return false;
        }
    }
}
