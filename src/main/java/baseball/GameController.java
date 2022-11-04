package baseball;

import java.util.List;

public class GameController {
    Computer computer;

    public GameController() {
        computer = new Computer();
    }

    public void startGame() {
        List<Integer> computerAnswer = computer.generateRandomNums();
        System.out.println(computerAnswer);
    }
}
