package baseball.domain;

import java.util.List;

public class BaseballNumber {
    private List<Integer> baseballNumberList;

    public BaseballNumber(List<Integer> baseballNumbers) {
        baseballNumberList = baseballNumbers;
    }

    public BaseballResult judgeBaseballResult(BaseballNumber playerAnswer) {
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
}
