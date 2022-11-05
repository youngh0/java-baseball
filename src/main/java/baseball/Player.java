package baseball;

import baseball.domain.BaseballNumber;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    public BaseballNumber inputAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String nums = Console.readLine();
        System.out.println();
        return new BaseballNumber(nums);
    }
}
