package baseball;

import baseball.domain.BaseballNumberList;
import baseball.domain.BaseballResult;
import baseball.inputValidation.InputValidation;
import baseball.view.InputView;

public class GameController {
    Computer computer;
    Player player;
    InputValidation inputValidation;

    public GameController() {
        computer = new Computer();
        player = new Player();
        inputValidation = new InputValidation();
    }

    public void startGame() {
        BaseballNumberList computerAnswer = computer.generateRandomNums();
        while (true) {
            BaseballNumberList playerInputNumbers = player.inputAnswer();
            BaseballResult baseballResult = computerAnswer.judgeBaseballResult(playerInputNumbers);
            baseballResult.showResult();
            if (baseballResult.isThreeStrike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                askReplayBaseball();
                break;
            }
        }
    }

    private void askReplayBaseball() {
        String playerReplayInput = InputView.askReplay();
        inputValidation.validateReplayInputValidation(playerReplayInput);
        if (playerReplayInput.equals("1")) {
            startGame();
        }
    }
}
