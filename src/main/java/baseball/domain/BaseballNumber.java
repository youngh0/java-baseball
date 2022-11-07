package baseball.domain;

import java.util.Objects;

public class BaseballNumber {
    private final int MIN_NUMBER_RANGE = 1;
    private final int MAX_NUMBER_RANGE = 9;
    private int number;

    public BaseballNumber(int number) {
        if (!validateRangeOneToNine(number)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    private boolean validateRangeOneToNine(int number) {
        return number >= MIN_NUMBER_RANGE && number <= MAX_NUMBER_RANGE;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BaseballNumber)) {
            return false;
        }
        BaseballNumber baseballNumber = (BaseballNumber) o;
        return baseballNumber.number == this.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
