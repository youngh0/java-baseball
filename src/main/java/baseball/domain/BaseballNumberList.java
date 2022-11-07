package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumberList {
    private List<BaseballNumber> baseballNumberList;

    public BaseballNumberList(List<Integer> baseballNumbers) {
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
