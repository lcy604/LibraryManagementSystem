package org.andy.librarymanagementsystem.command;

import org.andy.librarymanagementsystem.command.Impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andy
 * @created 2024/1/16/016
 */
public class CommandFactory {
    private Map<String, Command> commands = new HashMap<>();

    public CommandFactory() {
        commands.put("register", new RegisterCommand());
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("add", new AddCommand());
        commands.put("delete", new DeleteCommand());
        commands.put("search", new SearchCommand());
        commands.put("borrow", new BorrowCommand());
        commands.put("return", new ReturnCommand());
        commands.put("list", new ListCommand());
        commands.put("exit", new ExitCommand());
    }

    public Command getCommand(String command) {
        return commands.getOrDefault(command.toLowerCase(), null);
    }
}
