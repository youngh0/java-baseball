package baseball.domain;

import java.util.Objects;

public class BaseballNumber {
    private int number;

    public BaseballNumber(int number) {
        System.out.println("aa");
        this.number = number;
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
