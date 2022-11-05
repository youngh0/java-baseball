package baseball.inputValidation;

import java.util.*;

public class InputValidation {
    private final String REPLAY_INPUT_REGEX = "[1-2]{1,1}";
    private final int PLAYER_ANSWER_CORRECT_SIZE = 3;
    private final String PLAYER_ANSWER_REGEX = "^[1-9]*";

    public void validateReplayInputValidation(String replayInput) {
        if (!replayInput.matches(REPLAY_INPUT_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public void validatePlayerInput(String inputNumbers) {
        validateThreeLength(inputNumbers);
        validateOnlyDigits(inputNumbers);
        validateIsNonDuplicateNums(inputNumbers);
    }

    private void validateThreeLength(String inputNumbers) {
        if (inputNumbers.length() != PLAYER_ANSWER_CORRECT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOnlyDigits(String inputNumbers) {
        if (!inputNumbers.matches(PLAYER_ANSWER_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIsNonDuplicateNums(String inputNumbers) {
        Set<Character> inputSet = new HashSet<>();
        for (char c : inputNumbers.toCharArray()) {
            inputSet.add(c);
        }
        if (inputSet.size() != PLAYER_ANSWER_CORRECT_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
