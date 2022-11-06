package baseball.domain;

import baseball.view.OutputView;

public class BaseballResult {
    private final int MAX_STRIKE_COUNT = 3;
    private int strikeCount;
    private int ballCount;

    public BaseballResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isThreeStrike() {
        return strikeCount == MAX_STRIKE_COUNT;
    }

    public void showResult() {
        OutputView.printBallStrikeCount(strikeCount, ballCount);
    }
}
