package baseball.domain;

public class BaseballResult {
    private final int strikeCount;
    private final int ballCount;

    public BaseballResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isFinish() {
        return strikeCount == 3;
    }

    public StringBuffer getResultMessage() {
        StringBuffer result = new StringBuffer();
        if (strikeCount == 0 && ballCount == 0) {
            return result.append("낫싱");
        }
        result.append(getBallMessage());
        result.append(getStrikeMessage());
        return result;
    }

    private StringBuffer getBallMessage() {
        StringBuffer ballResult = new StringBuffer();
        if (ballCount > 0) {
            return ballResult.append(ballCount).append("볼 ");
        }
        return ballResult;
    }

    private StringBuffer getStrikeMessage() {
        StringBuffer strikeResult = new StringBuffer();
        if (strikeCount > 0) {
            return strikeResult.append(strikeCount).append("스트라이크");
        }
        return strikeResult;
    }
}
