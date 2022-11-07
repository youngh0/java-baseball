package baseball.controller;

import baseball.domain.BaseballNumberList;
import baseball.errorMessages.IllegalExceptionMessage;
import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static baseball.errorMessages.IllegalExceptionMessage.DIGIT_INCORRECT;

public class Player {
    private final static int PLAYER_ANSWER_CORRECT_SIZE = 3;
    private final static String PLAYER_ANSWER_REGEX = "^[1-9]*";

    public BaseballNumberList inputAnswer() {
        String playerAnswer = InputView.requestPlayerInput();
        validatePlayerInput(playerAnswer);
        List<Integer> inputToIntegers = convertStringToIntegerList(playerAnswer);
        validateIsNonDuplicateNums(inputToIntegers);
        for (Integer inputToInteger : inputToIntegers) {
            System.out.print(inputToInteger + " ");
        }
        System.out.println();

        return new BaseballNumberList(inputToIntegers);
    }

    public void validatePlayerInput(String inputNumbers) {
        validateThreeLength(inputNumbers);
        validateSatisfiedRange(inputNumbers);
    }

    private List<Integer> convertStringToIntegerList(String nums) {
        List<Integer> integerList = new ArrayList<>();
        for (char num : nums.toCharArray()) {
            integerList.add(Integer.parseInt(String.valueOf(num)));
        }
        return integerList;
    }

    private static void validateThreeLength(String inputNumbers) {
        if (inputNumbers.length() != PLAYER_ANSWER_CORRECT_SIZE) {
            throw new IllegalArgumentException(DIGIT_INCORRECT);
        }
    }

    private static void validateSatisfiedRange(String inputNumbers) {
        if (!inputNumbers.matches(PLAYER_ANSWER_REGEX)) {
            throw new IllegalArgumentException(IllegalExceptionMessage.ONLY_NUMBER);
        }
    }

    private static void validateIsNonDuplicateNums(List<Integer> input) {
        long individualNumberCount = input.stream()
                .distinct()
                .count();
        if (individualNumberCount != PLAYER_ANSWER_CORRECT_SIZE) {
            throw new IllegalArgumentException(IllegalExceptionMessage.DUPLICATE_NUMBER);
        }
    }
}
