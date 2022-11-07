package baseball.inputValidation;

import baseball.errorMessages.IllegalExceptionMessage;

public class InputValidation {
    private final static String REPLAY_INPUT_REGEX = "[1-2]";

    public static void validateReplayInputValidation(String replayInput) {
        if (!replayInput.matches(REPLAY_INPUT_REGEX)) {
            throw new IllegalArgumentException(IllegalExceptionMessage.REPLAY_EXCEPTION_MESSAGE);
        }
    }
}
