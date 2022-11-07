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
        boolean replayGame = false;
        while(!replayGame){
            computerAnswer = computer.generateRandomNums();
            playGame();
            replayGame = askReplayBaseball();
        }
    }

    private boolean askReplayBaseball() {
        String playerReplayInput = InputView.askReplay();
        InputValidation.validateReplayInputValidation(playerReplayInput);
        return playerReplayInput.equals("1");
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
