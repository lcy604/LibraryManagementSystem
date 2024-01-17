package org.andy.librarymanagementsystem.command;

import org.andy.librarymanagementsystem.service.BookService;
import org.andy.librarymanagementsystem.service.BorrowRecordService;
import org.andy.librarymanagementsystem.service.UserService;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public interface Command {
    void execute(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens);
}
