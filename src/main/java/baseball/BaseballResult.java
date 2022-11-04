package baseball;

import java.util.List;

public class BaseballResult {
    private final int MAX_ANSWER_SIZE = 3;
    private int strikeCount;
    private int ballCount;

    public BaseballResult(List<Integer> computerAnswer, List<Integer> playerAnswer) {
        judgeBaseballResult(computerAnswer, playerAnswer);
    }

    private void judgeBaseballResult(List<Integer> computerAnswer, List<Integer> playerAnswer) {
        strikeCount = 0;
        ballCount = 0;
        for (int num = 0; num < MAX_ANSWER_SIZE; num++) {
            if (playerAnswer.get(num).equals(computerAnswer.get(num))) {
                strikeCount++;
                continue;
            }
            if (computerAnswer.contains(playerAnswer.get(num))) {
                ballCount++;
            }
        }
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
