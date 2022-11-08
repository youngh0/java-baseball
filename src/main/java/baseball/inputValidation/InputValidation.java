package baseball.inputValidation;

import baseball.errorMessages.IllegalExceptionMessage;

public class InputValidation {
    public static void validateReplayInputValidation(String replayInput) {
        if (!(replayInput.equals("1") || replayInput.equals("2"))) {
            throw new IllegalArgumentException(IllegalExceptionMessage.REPLAY_EXCEPTION_MESSAGE);
        }
    }
}
