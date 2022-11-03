package baseball;

import java.util.ArrayList;
import java.util.List;

public class NumsChecker {
    private final int MAX_NUMS_SIZE = 3;
    private final String NUMS_REGEX = "^[1-9]*";

    public boolean checkNumsValidation(String nums) {
        return checkIsOnlyDigit(nums) && checkIsNonDuplicateNums(nums);
    }

    private boolean checkIsNonDuplicateNums(String nums) {
        return convertStringToIntegerList(nums).stream()
                .distinct()
                .count() == MAX_NUMS_SIZE;
    }
    private boolean checkIsOnlyDigit(String nums) {
        return nums.matches(NUMS_REGEX);
    }

    private List<Integer> convertStringToIntegerList (String nums) {
        List<Integer> integerList = new ArrayList<>();
        for (char num : nums.toCharArray()) {
            integerList.add(Integer.parseInt(String.valueOf(num)));
        }
        return integerList;
    }
}
