package baseball;

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
        BaseballNumberList computerAnswer = computer.generateRandomNums();
        while (true) {
            BaseballNumberList playerInputNumbers = player.inputAnswer();
            BaseballResult baseballResult = computerAnswer.judgeBaseballResult(playerInputNumbers);
            baseballResult.showResult();
            if (baseballResult.isThreeStrike()) {
                askReplayBaseball();
                break;
            }
        }
    }

    private void askReplayBaseball() {
        String playerReplayInput = InputView.askReplay();
        InputValidation.validateReplayInputValidation(playerReplayInput);
        if (playerReplayInput.equals("1")) {
            startGame();
        }
    }
}
