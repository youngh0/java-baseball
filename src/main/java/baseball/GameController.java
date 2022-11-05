package baseball;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballResult;
import baseball.inputValidation.InputValidation;
import camp.nextstep.edu.missionutils.Console;

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
        BaseballNumber computerAnswer = computer.generateRandomNums();
        while (true) {
            BaseballNumber playerInputNumbers = player.inputAnswer();
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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerInput = Console.readLine();
        inputValidation.validateReplayInputValidation(playerInput);
        if (playerInput.equals("1")) {
            startGame();
        }
    }
}
