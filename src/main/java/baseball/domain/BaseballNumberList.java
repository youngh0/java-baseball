package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumberList {
    private List<Integer> baseballNumberList;

    public BaseballNumberList(List<Integer> baseballNumbers) {
        baseballNumberList = new ArrayList<>(baseballNumbers);
    }

    public BaseballResult judgeBaseballResult(List<Integer> playerAnswer) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int num = 0; num < 3; num++) {
            if (this.baseballNumberList.get(num).equals(playerAnswer.get(num))) {
                strikeCount++;
                continue;
            }
            if (this.baseballNumberList.contains(playerAnswer.get(num))) {
                ballCount++;
            }
        }
        return new BaseballResult(strikeCount, ballCount);
    }
}
