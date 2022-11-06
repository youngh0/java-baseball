package baseball;

import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        OutputView.startBaseballGame();
        gameController.startGame();
        // TODO: 프로그램 구현
    }
}
