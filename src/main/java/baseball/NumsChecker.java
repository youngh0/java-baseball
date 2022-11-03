package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class NumsChecker {
    private final int MAX_NUMS_SIZE = 3;
    public boolean checkIsNonDuplicateNums(List<Integer> nums) {
        return nums.stream()
                .distinct()
                .count() == MAX_NUMS_SIZE;

    }
}
