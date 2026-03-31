package com.assignment.command;

import java.util.Map;

public class CommandFactory {

    private static final Map<Character, Command> COMMAND_MAP = Map.of(
            'F', new ForwardCommand(),
            'B', new BackwardCommand(),
            'L', new LeftCommand(),
            'R', new RightCommand()
    );

    public static Command get(char c) {
        Command cmd = COMMAND_MAP.get(Character.toUpperCase(c));
        if (cmd == null) {
            throw new IllegalArgumentException("Invalid command: " + c);
        }
        return cmd;
    }
}