package baseball.controller;

import baseball.domain.BaseballNumberList;
import baseball.domain.BaseballResult;
import baseball.inputValidation.InputValidation;
import baseball.view.InputView;

import java.util.List;

public class GameController {
    Computer computer;
    Player player;
    BaseballNumberList computerAnswer;

    public GameController() {
        computer = new Computer();
        player = new Player();
    }

    public void startGame() {
        computerAnswer = computer.generateRandomNums();
        playGame();
        askReplayBaseball();
    }

    private boolean askReplayBaseball() {
        String playerReplayInput = InputView.askReplay();
        InputValidation.validateReplayInputValidation(playerReplayInput);
        if (playerReplayInput.equals("1")) {
            startGame();
        }
        return false;
    }

    private void playGame() {
        boolean correctAnswer = false;
        while (!correctAnswer) {
            List<Integer> playerInputAnswer = player.inputAnswer();
            BaseballResult baseballResult = computerAnswer.judgeBaseballResult(playerInputAnswer);
            baseballResult.showResult();
            correctAnswer = baseballResult.isThreeStrike();
        }
    }
}
