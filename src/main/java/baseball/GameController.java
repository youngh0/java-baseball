package baseball;

import baseball.service.GameSettingService;
import baseball.service.ProgressGameService;

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
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String playerReplayInput = Console.readLine();
            replayGame = progressGameService.endGame(playerReplayInput);
        }
    }
}
