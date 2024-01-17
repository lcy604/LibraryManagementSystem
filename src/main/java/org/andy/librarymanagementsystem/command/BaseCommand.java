package org.andy.librarymanagementsystem.command;

import org.andy.librarymanagementsystem.service.BookService;
import org.andy.librarymanagementsystem.service.BorrowRecordService;
import org.andy.librarymanagementsystem.service.UserService;

/**
 * @author Andy
 * @created 2024/1/17/017
 */
public abstract class BaseCommand implements Command{
    public void run(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens){
        if(validate(userService, bookService, borrowRecordService, tokens)) {
            execute(userService, bookService, borrowRecordService, tokens);
        }
    }
}
