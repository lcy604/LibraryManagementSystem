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
    UserService userService;
    BookService bookService;
    BorrowRecordService borrowRecordService;
    CommandFactory commandFactory;

    public LibraryManagementSystem() {
        init();
    }

    private void init() {
        userService = new UserService(new InMemoryUserRepository());
        InMemoryBorrowRecordRepository borrowRecordRepository = new InMemoryBorrowRecordRepository();
        bookService = new BookService(new InMemoryBookRepository(), borrowRecordRepository);
        borrowRecordService = new BorrowRecordService(borrowRecordRepository);
        commandFactory = new CommandFactory();
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print("$ ");
                    String commandLine = scanner.nextLine();
                    String[] tokens = commandLine.trim().split("\\s+(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                    if (tokens.length == 0) {
                        continue;
                    }
                    // Remove double quotes and space from the parsed tokens in the head and tail
                    for (int i = 0; i < tokens.length; i++) {
                        tokens[i] = tokens[i].replaceAll("^\"|\"$", "");
                        tokens[i] = tokens[i].replaceAll("^\\s|\\s$", "");
                    }

                    Command command = commandFactory.getCommand(tokens[0]);
                    Optional.ofNullable(command).ifPresentOrElse(c -> c.run(userService, bookService, borrowRecordService, tokens), ()-> {
                        System.out.println(String.format("command:%s is not a valid command.", tokens[0]));
                    });
                    if (command instanceof ExitCommand) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Internal server error");
                }
            }
        }
    }

    public static void main(String[] args) {
        new LibraryManagementSystem().run();
    }
}
