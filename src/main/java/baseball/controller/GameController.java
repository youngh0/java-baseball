package baseball.controller;

import baseball.domain.BaseballNumberList;
import baseball.domain.BaseballResult;
import baseball.inputValidation.InputValidation;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

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
        boolean replayGame = true;
        while(replayGame){
            computerAnswer = computer.generateRandomNums();
            System.out.println(computerAnswer.toString());
            playGame();
            replayGame = askNotReplayBaseball();
        }
    }

    private boolean askNotReplayBaseball() {
        String playerReplayInput = Console.readLine();
        InputView.askReplay();
        InputValidation.validateReplayInputValidation(playerReplayInput);
        return playerReplayInput.equals("1");
    }

    private void playGame() {
        boolean correctAnswer = false;
        while (!correctAnswer) {
            String playerInputAnswer = Console.readLine();
            List<Integer> playerAnswers = player.inputAnswer(playerInputAnswer);
            BaseballResult baseballResult = computerAnswer.judgeBaseballResult(playerAnswers);
            baseballResult.showResult();
            correctAnswer = baseballResult.isThreeStrike();
        }
    }
}
