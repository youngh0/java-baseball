package baseball;

import baseball.service.GameSettingService;
import baseball.service.ProgressGameService;
import camp.nextstep.edu.missionutils.Console;
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
            progressGameService.playGame(computerAnswer);
            replayGame = askReplayBaseball();
        }
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
