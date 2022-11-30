package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbersValidator {
    public static void validatePlayerBaseballInput(String baseballInputValue) {
        isOnlyDigit(baseballInputValue);
        isDuplicateBaseballNumbers(convertToBaseballNumber(baseballInputValue));
    }

    private static void isOnlyDigit(String baseballInputValue) {
        String digitRegex = "[1-9]{3}";
        if (baseballInputValue.matches(digitRegex)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private static List<Integer> convertToBaseballNumber(String baseballInputValue) {
        List<Integer> convertBaseball = new ArrayList<>();
        for (char baseballNumber : baseballInputValue.toCharArray()) {
            convertBaseball.add(Integer.parseInt(String.valueOf(baseballNumber)));
        }
        return convertBaseball;
    }

    private static void isDuplicateBaseballNumbers(List<Integer> baseballNumbers) {
        long nonDuplicateNumberCount = baseballNumbers.stream()
                .distinct()
                .count();
        if (nonDuplicateNumberCount != 3) {
            throw new IllegalArgumentException();
        }
    }
}
