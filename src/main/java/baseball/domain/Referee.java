package baseball.domain;

import java.util.List;

public class Referee {
    public BaseballResult judgeBaseballGame(List<Integer> computer, List<Integer> playerAnswer) {
        int strikeCount = countStrike(computer, playerAnswer);
        int ballCount = countBall(computer, playerAnswer);
        return new BaseballResult(strikeCount, ballCount);
    }

    private int countStrike(List<Integer> computer, List<Integer> playerAnswer) {
        int strikeCount = 0;
        for (int index = 0; index < computer.size(); index++) {
            if (computer.get(index) == playerAnswer.get(index)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(List<Integer> computer, List<Integer> playerAnswer) {
        int ballCount = 0;
        for (int index = 0; index < computer.size(); index++) {
            if (computer.contains(playerAnswer.get(index))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
