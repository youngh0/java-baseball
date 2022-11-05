package baseball.domain;

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
        StringBuilder resultString = new StringBuilder();
        if (ballCount > 0) {
            resultString.append(ballCount).append("볼 ");
        }
        if (strikeCount > 0) {
            resultString.append(strikeCount).append("스트라이크");
        }
        if (ballCount + strikeCount == 0) {
            resultString.append("낫싱");
        }
        System.out.println(resultString);
    }
}
