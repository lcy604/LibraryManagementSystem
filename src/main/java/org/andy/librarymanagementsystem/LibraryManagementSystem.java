package org.andy.librarymanagementsystem;

import org.andy.librarymanagementsystem.command.Command;
import org.andy.librarymanagementsystem.command.CommandFactory;
import org.andy.librarymanagementsystem.command.Impl.ExitCommand;
import org.andy.librarymanagementsystem.repository.BorrowRecordRepository;
import org.andy.librarymanagementsystem.repository.factory.InMemoryRepositoryFactory;
import org.andy.librarymanagementsystem.repository.factory.RepositoryFactory;
import org.andy.librarymanagementsystem.repository.impl.InMemoryBookRepositoryImplement;
import org.andy.librarymanagementsystem.repository.impl.InMemoryBorrowRecordRepositoryImplement;
import org.andy.librarymanagementsystem.repository.impl.InMemoryUserRepositoryImplement;
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
        RepositoryFactory repositoryFactory = new InMemoryRepositoryFactory();
        userService = new UserService(repositoryFactory.getUserRepositoryImplement());
        BorrowRecordRepository borrowRecordRepository = repositoryFactory.getBorrowRecordRepository();
        bookService = new BookService(new InMemoryBookRepositoryImplement(), borrowRecordRepository);
        borrowRecordService = new BorrowRecordService(borrowRecordRepository);
        commandFactory = new CommandFactory();
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print("$ ");
                    String commandLine = scanner.nextLine();
                    // handle only new line is input
                    if(commandLine.length() == 0){
                        System.out.println("");
                        continue;
                    }
                    String[] tokens = parseCommand(commandLine);
                    if (tokens == null) continue;

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

    private static String[] parseCommand(String commandLine) {
        String[] tokens = commandLine.trim().split("\\s+(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        if (tokens.length == 0) {
            System.out.println(String.format("Invalid command: %s", commandLine));
            return null;
        }
        // Remove double quotes and space from the parsed tokens in the head and tail
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].replaceAll("^\"|\"$", "");
            tokens[i] = tokens[i].replaceAll("^\\s|\\s$", "");
        }
        return tokens;
    }

    public static void main(String[] args) {
        new LibraryManagementSystem().run();
    }
}
