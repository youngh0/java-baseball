package baseball.view;

import baseball.domain.BaseballNumbers;
import baseball.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static InputView inputView = new InputView();
    private InputView(){

    }

    public static InputView getInputViewInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public BaseballNumbers inputPlayerAnswer() {
        System.out.print("숫자를 입력해주세요: ");
        String inputAnswer = Console.readLine();
        InputValidator.validatePlayerBaseballInput(inputAnswer);
        return new BaseballNumbers(convertToBaseballNumbers(inputAnswer));
    }

    public String inputRetryCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String retryCommand = Console.readLine();
        InputValidator.validateRetryCommand(retryCommand);
        return retryCommand;
    }

    private List<Integer> convertToBaseballNumbers(String inputAnswer) {
        List<Integer> convertBaseball = new ArrayList<>();
        for (char baseballNumber : inputAnswer.toCharArray()) {
            convertBaseball.add(Integer.parseInt(String.valueOf(baseballNumber)));
        }
        return convertBaseball;
    }
}
