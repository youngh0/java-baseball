package baseball;

import baseball.service.GameSettingService;
import baseball.service.ProgressGameService;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private GameSettingService gameSettingService;
    private ProgressGameService progressGameService;

    public GameController() {
        gameSettingService = new GameSettingService();
        progressGameService = new ProgressGameService();
    }

    public void startGame() {
        boolean replayGame = true;
        while(replayGame){
            List<Integer> computerAnswer = gameSettingService.generateRandomThreeNumbers();
            playGame(computerAnswer);
            replayGame = askReplayBaseball();
        }
    }

    private void playGame(List<Integer> computerAnswer) {
        List<Integer> baseballResult;
        boolean correctAnswer = false;
        while (!correctAnswer) {
            List<Integer> playerInputAnswer = progressGameService.playGame(computerAnswer);
            baseballResult = judgeBaseballResult(computerAnswer, playerInputAnswer);
            showResult(baseballResult.get(0), baseballResult.get(1));
            correctAnswer = isThreeStrike(baseballResult.get(0));
        }
    }

    public List<Integer> judgeBaseballResult(List<Integer> computerAnswer, List<Integer> playerAnswer) {
        List<Integer> result = new ArrayList<>(List.of(0, 0));
        for (int num = 0; num < 3; num++) {
            if (computerAnswer.get(num).equals(playerAnswer.get(num))) {
                result.set(0, result.get(0)+1);
                continue;
            }
            if (computerAnswer.contains(playerAnswer.get(num))) {
                result.set(1, result.get(1)+1);
            }
        }
        return result;
    }

    public boolean isThreeStrike(int strikeCount) {
        final String finishGame = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        final int MAX_STRIKE_COUNT = 3;
        if (strikeCount == MAX_STRIKE_COUNT) {
            System.out.println(finishGame);
            return true;
        }
        return false;
    }

    public void showResult(int strikeCount, int ballCount) {
        StringBuilder resultString = new StringBuilder();
        if (ballCount > 0) {
            resultString.append(ballCount).append("볼 ");
        }
        if (strikeCount > 0) {
            resultString.append(strikeCount).append("스트라이크");
        }
        if (ballCount + strikeCount == 0) {
            resultString.append("낫싱");
        }
        System.out.println(resultString);
    }

    private boolean askReplayBaseball() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerReplayInput = Console.readLine();
        validateReplayInputValidation(playerReplayInput);
        return playerReplayInput.equals("1");
    }

    private void validateReplayInputValidation(String replayInput) {
        if (!(replayInput.equals("1") || replayInput.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }


}
