package baseball;

import baseball.domain.BaseballNumberList;
import baseball.inputValidation.InputValidation;
import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Player {
    InputValidation inputValidation;

    public Player() {
        inputValidation = new InputValidation();
    }

    public BaseballNumberList inputAnswer() {
        String playerAnswer = InputView.requestPlayerInput();
        inputValidation.validatePlayerInput(playerAnswer);
        List<Integer> inputToIntegers = convertStringToIntegerList(playerAnswer);
        System.out.println();
        return new BaseballNumberList(inputToIntegers);
    }

    private List<Integer> convertStringToIntegerList(String nums) {
        List<Integer> integerList = new ArrayList<>();
        for (char num : nums.toCharArray()) {
            integerList.add(Integer.parseInt(String.valueOf(num)));
        }
        return integerList;
    }
}
