package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final int MAX_SIZE = 3;
    List<Integer> computerAnswer;

    public Computer() {
        computerAnswer = new ArrayList<>();
    }

    public List<Integer> generateRandomNums() {
        while (computerAnswer.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }

        return computerAnswer;
    }
}
