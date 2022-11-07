package baseball.controller;

import baseball.domain.BaseballNumberList;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final int MAX_SIZE = 3;
    List<Integer> integerNumbers;

    public Computer() {
        integerNumbers = new ArrayList<>();
    }

    public BaseballNumberList generateRandomNums() {
        integerNumbers.clear();
        while (integerNumbers.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!integerNumbers.contains(randomNumber)) {
                integerNumbers.add(randomNumber);
            }
        }
        return new BaseballNumberList(integerNumbers);
    }

}
