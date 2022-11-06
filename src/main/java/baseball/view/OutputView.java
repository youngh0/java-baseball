package baseball.view;

public class OutputView {
    private static final String startGame = "숫자 야구 게임을 시작합니다.";
    private static final String finishGame = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void startBaseballGame() {
        System.out.println(startGame);
    }

    public static void printBallStrikeCount(int strikeCount, int ballCount) {
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
}
