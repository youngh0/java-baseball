package baseball.utils;

public class BaseballNumbersValidator {
    public static void validatePlayerBaseballInput(String baseballInputValue) {
        isOnlyDigit(baseballInputValue);
    }

    private static void isOnlyDigit(String baseballInputValue) {
        String digitRegex = "[1-9]{3}";
        if (baseballInputValue.matches(digitRegex)) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
