package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameController {
    private final String REPLAY_INPUT_REGEX = "[1-2]{1,1}";
    Computer computer;
    Player player;

    public GameController() {
        computer = new Computer();
        player = new Player();
    }

    public void startGame() {
        List<Integer> computerAnswer = computer.generateRandomNums();
        while (true) {
            List<Integer> integers = player.inputAnswer();
            BaseballResult baseballResult = new BaseballResult(computerAnswer, integers);
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
        if (!checkReplayInputValidation(Console.readLine())) {
            throw new IllegalArgumentException();
        }
        if (playerInput.equals("1")) {
            startGame();
        }
    }

    private boolean checkReplayInputValidation(String replayInput) {
        return replayInput.matches(REPLAY_INPUT_REGEX);
    }
}
