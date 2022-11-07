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
        if (strikeCount == MAX_STRIKE_COUNT) {
            OutputView.printFinishGameString();
            return true;
        }
        return false;
    }

    public void showResult() {
        OutputView.printBallStrikeCount(strikeCount, ballCount);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
