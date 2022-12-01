package baseball.utils;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum RetryCommand {
    RETRY("1"),
    QUIT("2");

    private final String command;

    RetryCommand(String command) {
        this.command = command;
    }

    private static final Map<String, RetryCommand> commands =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(RetryCommand::getCommand, Function.identity())));

    public String getCommand() {
        return command;
    }

    public static RetryCommand find(String command) {
        return commands.get(command);
    }
}
