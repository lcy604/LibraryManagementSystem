package org.andy.librarymanagementsystem;

import org.andy.librarymanagementsystem.command.Command;
import org.andy.librarymanagementsystem.command.CommandFactory;
import org.andy.librarymanagementsystem.command.Impl.ExitCommand;
import org.andy.librarymanagementsystem.repository.impl.InMemoryBookRepository;
import org.andy.librarymanagementsystem.repository.impl.InMemoryBorrowRecordRepository;
import org.andy.librarymanagementsystem.repository.impl.InMemoryUserRepository;
import org.andy.librarymanagementsystem.service.BookService;
import org.andy.librarymanagementsystem.service.BorrowRecordService;
import org.andy.librarymanagementsystem.service.UserService;

import java.util.Optional;
import java.util.Scanner;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class LibraryManagementSystem {
    public static void main(String[] args) {
        UserService userService = new UserService(new InMemoryUserRepository());
        InMemoryBorrowRecordRepository borrowRecordRepository = new InMemoryBorrowRecordRepository();
        BookService bookService = new BookService(new InMemoryBookRepository(), borrowRecordRepository);
        BorrowRecordService borrowRecordService = new BorrowRecordService(borrowRecordRepository);
        CommandFactory commandFactory = new CommandFactory();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("$ ");
                String commandLine = scanner.nextLine();
                String[] tokens = commandLine.trim().split("\\s+(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (tokens.length == 0){
                    continue;
                }
                // Remove double quotes from the parsed tokens
                for (int i = 0; i < tokens.length; i++) {
                    tokens[i] = tokens[i].replaceAll("^\"|\"$", "");
                }

                Command command = commandFactory.getCommand(tokens[0]);
                Optional.ofNullable(command).ifPresent(c -> c.execute(userService, bookService, borrowRecordService, tokens));
                if (command instanceof ExitCommand){
                    break;
                }
            }
        }
    }
}
