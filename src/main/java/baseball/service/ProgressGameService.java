package baseball.service;

import baseball.repository.BaseballResult;
import baseball.utils.PlayerInputValidator;
import baseball.view.InputView;

import java.util.List;

public class ProgressGameService {
    private PlayerInputValidator playerInputValidator;
    private BaseballResult baseballResult;

    public ProgressGameService() {
        playerInputValidator = new PlayerInputValidator();
    }

    public List<Integer> playGame(List<Integer> computerAnswer) {
        String playerAnswerInput = InputView.requestPlayerInput();
        return playerInputValidator.validatePlayerAnswerInput(playerAnswerInput);
    }
}
