package baseball.domain;

public class Referee {
    public BaseballResult judgeBaseballGame(BaseballNumbers computer, BaseballNumbers playerAnswer) {
        int strikeCount = countStrike(computer, playerAnswer);
        int ballCount = countBall(computer, playerAnswer);
        return new BaseballResult(strikeCount, ballCount);
    }

    private int countStrike(BaseballNumbers computer, BaseballNumbers playerAnswer) {
        int strikeCount = 0;
        for (int index = 0; index < 3; index++) {
            if (computer.isStrike(index, playerAnswer)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(BaseballNumbers computer, BaseballNumbers playerAnswer) {
        int ballCount = 0;
        for (int index = 0; index < 3; index++) {
            if (computer.isBall(index, playerAnswer)) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
