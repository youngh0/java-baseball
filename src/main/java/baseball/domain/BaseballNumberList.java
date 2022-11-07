package baseball.domain;

import baseball.errorMessages.IllegalExceptionMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseballNumberList {
    private final int BASEBALL_NUMBER_LIST_MAX_SIZE = 3;
    private List<BaseballNumber> baseballNumberList;

    public BaseballNumberList(List<Integer> baseballNumbers) {
        if (baseballNumbers.size() != BASEBALL_NUMBER_LIST_MAX_SIZE && new HashSet<>(baseballNumbers).size() != BASEBALL_NUMBER_LIST_MAX_SIZE) {
            throw new IllegalArgumentException(IllegalExceptionMessage.DIGIT_INCORRECT);
        }
        baseballNumberList = new ArrayList<>();
        addBaseballNumber(baseballNumbers);
    }

    public BaseballResult judgeBaseballResult(BaseballNumberList playerAnswer) {
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

    private void addBaseballNumber(List<Integer> baseballNumbers) {
        for (Integer baseballNumber : baseballNumbers) {
            baseballNumberList.add(new BaseballNumber(baseballNumber));
        }
    }
}
