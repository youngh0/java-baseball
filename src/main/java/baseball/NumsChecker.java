package baseball;
import java.util.List;

public class NumsChecker {
    private final int MAX_NUMS_SIZE = 3;
    private final String NUMS_REGEX = "^[1-9]*";

    public boolean checkIsNonDuplicateNums(List<Integer> nums) {
        return nums.stream()
                .distinct()
                .count() == MAX_NUMS_SIZE;
    }

    public boolean checkIsOnlyDigit(String nums) {
        return nums.matches(NUMS_REGEX);
    }
}
