package baseball.service;

import baseball.repository.BaseballResult;
import baseball.utils.PlayerInputValidator;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

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
            correctAnswer = new BaseballResult().progressJudgement(computerAnswer, playerInputAnswer);
        }
    }

    public boolean endGame(String playerReplayInput) {
        playerInputValidator.validatePlayerReplayInput(playerReplayInput);
        return playerReplayInput.equals("1");
    }
}
