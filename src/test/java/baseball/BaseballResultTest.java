package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class BaseballResultTest {
    OutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
    }

    @Test
    void showResultTest() {
        List<Integer> computerAnswer = new ArrayList<>(List.of(1,4,5));
        List<Integer> playerAnswer = new ArrayList<>(List.of(1,4,7));

        BaseballResult baseballResult = new BaseballResult(computerAnswer, playerAnswer);
        baseballResult.showResult();
        Assertions.assertThat("2스트라이크").isEqualTo(out.toString().trim());
    }

    @Test
    void showResultBallTest() {
        List<Integer> computerAnswer = new ArrayList<>(List.of(1,4,5));
        List<Integer> playerAnswer = new ArrayList<>(List.of(3,7,1));

        BaseballResult baseballResult = new BaseballResult(computerAnswer, playerAnswer);
        baseballResult.showResult();
        Assertions.assertThat("1볼").isEqualTo(out.toString().trim());
    }

    @Test
    void showResultBallStrikeTest() {
        List<Integer> computerAnswer = new ArrayList<>(List.of(1,4,5));
        List<Integer> playerAnswer = new ArrayList<>(List.of(1,7,4));

        BaseballResult baseballResult = new BaseballResult(computerAnswer, playerAnswer);
        baseballResult.showResult();
        Assertions.assertThat("1볼 1스트라이크").isEqualTo(out.toString().trim());
    }

    @Test
    void showResultNothingTest() {
        List<Integer> computerAnswer = new ArrayList<>(List.of(1,4,5));
        List<Integer> playerAnswer = new ArrayList<>(List.of(3,7,8));

        BaseballResult baseballResult = new BaseballResult(computerAnswer, playerAnswer);
        baseballResult.showResult();
        Assertions.assertThat("낫싱").isEqualTo(out.toString().trim());
    }

    @Test
    void isThreeStrikeTest() {
        List<Integer> computerAnswer = new ArrayList<>(List.of(1, 4, 5));
        List<Integer> playerAnswer = new ArrayList<>(List.of(1, 4, 5));

        BaseballResult baseballResult = new BaseballResult(computerAnswer, playerAnswer);
        baseballResult.isThreeStrike();
        Assertions.assertThat(baseballResult.isThreeStrike()).isEqualTo(true);
    }
    @Test
    void isThreeStrikeFailTest() {
        List<Integer> computerAnswer = new ArrayList<>(List.of(1, 4, 5));
        List<Integer> playerAnswer = new ArrayList<>(List.of(1, 4, 6));

        BaseballResult baseballResult = new BaseballResult(computerAnswer, playerAnswer);
        baseballResult.isThreeStrike();
        Assertions.assertThat(baseballResult.isThreeStrike()).isEqualTo(false);
    }
}