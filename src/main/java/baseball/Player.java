package baseball;

import baseball.domain.BaseballNumber;
import baseball.inputValidation.InputValidation;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    InputValidation inputValidation;

    public Player() {
        inputValidation = new InputValidation();
    }

    public BaseballNumber inputAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String nums = Console.readLine();
        inputValidation.validatePlayerInput(nums);
        List<Integer> inputToIntegers = convertStringToIntegerList(nums);
        System.out.println();
        return new BaseballNumber(inputToIntegers);
    }

    private List<Integer> convertStringToIntegerList(String nums) {
        List<Integer> integerList = new ArrayList<>();
        for (char num : nums.toCharArray()) {
            integerList.add(Integer.parseInt(String.valueOf(num)));
        }
        return integerList;
    }
}
