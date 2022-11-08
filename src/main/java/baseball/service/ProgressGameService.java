package baseball.service;

import baseball.utils.PlayerInputValidator;
import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class ProgressGameService {
    private PlayerInputValidator playerInputValidator;

    public ProgressGameService() {
        playerInputValidator = new PlayerInputValidator();
    }

    public void playGame(List<Integer> computerAnswer) {
        boolean correctAnswer = false;
        while (!correctAnswer) {
            String playerAnswerInput = InputView.requestPlayerInput();
            List<Integer> playerInputAnswer = playerInputValidator.validatePlayerAnswerInput(playerAnswerInput);
            List<Integer> baseballResult = judgeBaseballResult(computerAnswer, playerInputAnswer);
            int strikeCount = baseballResult.get(0);
            int ballCount = baseballResult.get(1);
            showResult(strikeCount, ballCount);
            correctAnswer = isThreeStrike(strikeCount);
        }
    }

    public List<Integer> judgeBaseballResult(List<Integer> computerAnswer, List<Integer> playerAnswer) {
        List<Integer> result = new ArrayList<>(List.of(0, 0));
        for (int num = 0; num < 3; num++) {
            if (computerAnswer.get(num).equals(playerAnswer.get(num))) {
                result.set(0, result.get(0) + 1);
                continue;
            }
            if (computerAnswer.contains(playerAnswer.get(num))) {
                result.set(1, result.get(1) + 1);
            }
        }
        return result;
    }

    public boolean isThreeStrike(int strikeCount) {
        final String finishGame = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        final int MAX_STRIKE_COUNT = 3;
        if (strikeCount == MAX_STRIKE_COUNT) {
            System.out.println(finishGame);
            return true;
        }
        return false;
    }

    public void showResult(int strikeCount, int ballCount) {
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
