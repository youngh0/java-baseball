package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomBaseballNumberGenerator {
    private final int MIN_RANGE = 1;
    private final int MAX_RANGE = 9;
    private final int CORRECT_SIZE = 3;

    public List<Integer> createBaseballNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < CORRECT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
