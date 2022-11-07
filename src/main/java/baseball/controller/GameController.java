package baseball.controller;

import baseball.domain.BaseballNumberList;
import baseball.domain.BaseballResult;
import baseball.inputValidation.InputValidation;
import baseball.view.InputView;

public class GameController {
    Computer computer;
    Player player;

    public GameController() {
        computer = new Computer();
        player = new Player();
    }

    public void startGame() {
        boolean isContinueGame = true;
        BaseballNumberList computerAnswer = computer.generateRandomNums();
        while (isContinueGame) {
            BaseballNumberList playerInputNumbers = player.inputAnswer();
            BaseballResult baseballResult = computerAnswer.judgeBaseballResult(playerInputNumbers);
            baseballResult.showResult();
            if (baseballResult.isThreeStrike()) {
                isContinueGame = askReplayBaseball();
            }
        }
    }

    private boolean askReplayBaseball() {
        String playerReplayInput = InputView.askReplay();
        InputValidation.validateReplayInputValidation(playerReplayInput);
        if (playerReplayInput.equals("1")) {
            startGame();
        }
        return false;
    }
}
