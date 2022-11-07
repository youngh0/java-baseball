package baseball.view;

public class InputView {
    private final static String INPUT_PLAYER_ANSWER = "숫자를 입력해주세요 : ";
    private final static String ASK_REPLAY_STRING = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void requestPlayerInput() {
        System.out.print(INPUT_PLAYER_ANSWER);
    }

    public static void askReplay() {
        System.out.println(ASK_REPLAY_STRING);
    }
}
