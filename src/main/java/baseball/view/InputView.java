package baseball.view;

import baseball.domain.BaseballNumbers;
import baseball.utils.BaseballNumbersValidator;
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
        BaseballNumbersValidator.validatePlayerBaseballInput(inputAnswer);
        return new BaseballNumbers(convertToBaseballNumbers(inputAnswer));
    }

    private List<Integer> convertToBaseballNumbers(String inputAnswer) {
        List<Integer> convertBaseball = new ArrayList<>();
        for (char baseballNumber : inputAnswer.toCharArray()) {
            convertBaseball.add(Integer.parseInt(String.valueOf(baseballNumber)));
        }
        return convertBaseball;
    }
}
