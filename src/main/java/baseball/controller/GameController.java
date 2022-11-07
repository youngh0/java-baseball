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
        boolean notReplayGame = false;
        while(!notReplayGame){
            computerAnswer = computer.generateRandomNums();
            playGame();
            notReplayGame = askNotReplayBaseball();
        }
    }

    private boolean askNotReplayBaseball() {
        String playerReplayInput = InputView.askReplay();
        InputValidation.validateReplayInputValidation(playerReplayInput);
        return playerReplayInput.equals("2");
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
