package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballResult;
import baseball.domain.BaseballRule;
import baseball.utils.RetryCommand;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final InputView inputView = InputView.getInputViewInstance();
    private final OutputView outputView = OutputView.getOutViewInstance();
    private final BaseballRule baseballRule = new BaseballRule();

    // TODO: 출력 문 뱔도의 상수로 분리
    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean progressEntireGame = true;
        while (progressEntireGame) {
            BaseballNumbers computerAnswer = baseballRule.createComputerAnswer();
            playOneGame(computerAnswer);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            progressEntireGame = progressRetryGame();
        }
    }

    private void playOneGame(BaseballNumbers computerAnswer) {
        boolean progress = true;
        while (progress) {
            BaseballNumbers playerAnswer = inputView.inputPlayerAnswer();
            BaseballResult baseballResult = baseballRule.playOneGame(computerAnswer, playerAnswer);
            outputView.printGameResult(baseballResult.getResultMessage());
            progress = baseballResult.isGameContinue();
        }
    }

    private boolean progressRetryGame() {
        String retryCommand = inputView.inputRetryCommand();
        return RetryCommand.find(retryCommand) == RetryCommand.RETRY;
    }
}
