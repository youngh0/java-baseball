package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    private final int MAX_NUMS_SIZE = 3;
    private final String NUMS_REGEX = "^[1-9]*";
    private List<Integer> baseballNumberList;

    public BaseballNumber(List<Integer> baseballNumbers) {
        baseballNumberList = baseballNumbers;
    }

    public BaseballNumber(String inputNumbers) {
        validatePlayerInput(inputNumbers);
        baseballNumberList = convertStringToIntegerList(inputNumbers);
    }

    private void validatePlayerInput(String inputNumbers) {
        validateThreeLength(inputNumbers);
        validateOnlyDigits(inputNumbers);
        validateIsNonDuplicateNums(inputNumbers);
    }

    private void validateThreeLength(String inputNumbers) {
        if (inputNumbers.length() != MAX_NUMS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOnlyDigits(String inputNumbers) {
        if (!inputNumbers.matches(NUMS_REGEX)) {
            throw new IllegalArgumentException();
        }

    }

    private void validateIsNonDuplicateNums(String inputNumbers) {
        long count = convertStringToIntegerList(inputNumbers).stream()
                .distinct()
                .count();
        if (count != 3) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> convertStringToIntegerList(String nums) {
        List<Integer> integerList = new ArrayList<>();
        for (char num : nums.toCharArray()) {
            integerList.add(Integer.parseInt(String.valueOf(num)));
        }
        return integerList;
    }

    public BaseballResult judgeBaseballResult(BaseballNumber playerAnswer) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int num = 0; num < 3; num++) {
            if (this.baseballNumberList.get(num).equals(playerAnswer.baseballNumberList.get(num))) {
                strikeCount++;
                continue;
            }
            if (this.baseballNumberList.contains(playerAnswer.baseballNumberList.get(num))) {
                ballCount++;
            }
        }
        return new BaseballResult(strikeCount, ballCount);
    }
}
