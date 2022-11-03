package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private AnswerChecker answerChecker;

    public Player() {
        answerChecker = new AnswerChecker();
    }

    public List<Integer> inputAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String nums = Console.readLine();
        if(!answerChecker.checkAnswerValidation(nums)){
            throw new IllegalArgumentException();
        }
        System.out.println();
        return convertStringToIntegerList(nums);
    }

    private List<Integer> convertStringToIntegerList (String nums) {
        List<Integer> integerList = new ArrayList<>();
        for (char num : nums.toCharArray()) {
            integerList.add(Integer.parseInt(String.valueOf(num)));
        }
        return integerList;
    }
}
