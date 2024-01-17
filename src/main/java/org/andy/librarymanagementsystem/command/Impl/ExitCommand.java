package org.andy.librarymanagementsystem.command.Impl;

import org.andy.librarymanagementsystem.command.BaseCommand;
import org.andy.librarymanagementsystem.command.Command;
import org.andy.librarymanagementsystem.service.BookService;
import org.andy.librarymanagementsystem.service.BorrowRecordService;
import org.andy.librarymanagementsystem.service.UserService;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class ExitCommand  extends BaseCommand {

    @Override
    public void execute(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        System.out.println("Exiting Library Management System. Goodbye!");
    }

    @Override
    public boolean validate(UserService userService, BookService bookService, BorrowRecordService borrowRecordService, String[] tokens) {
        return true;
    }
}
