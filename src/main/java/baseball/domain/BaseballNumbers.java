package baseball.domain;

import java.util.List;

public class BaseballNumbers {
    private final List<Integer> baseballNumbers;

    public BaseballNumbers(List<Integer> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public boolean isStrike(int index, BaseballNumbers playerAnswer) {
        return this.baseballNumbers.get(index) == playerAnswer.baseballNumbers.get(index);
    }

    public boolean isBall(int index, BaseballNumbers playerAnswer) {
        return this.baseballNumbers.contains(playerAnswer.baseballNumbers.get(index)) &&
                this.baseballNumbers.get(index) != playerAnswer.baseballNumbers.get(index);
    }
}
