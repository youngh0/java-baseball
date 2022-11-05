package baseball;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

class BaseballResultTest {
    OutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
    }

    @Test
    void showResultTest() {
        BaseballNumber computer = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber player = new BaseballNumber(List.of(1, 2, 3));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        baseballResult.showResult();
        Assertions.assertThat(out.toString().trim()).isEqualTo("3스트라이크");
    }

    @Test
    void showResultBallTest() {
        BaseballNumber computer = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber player = new BaseballNumber(List.of(4, 3, 5));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        baseballResult.showResult();
        Assertions.assertThat("1볼").isEqualTo(out.toString().trim());
    }

    @Test
    void showResultBallStrikeTest() {
        BaseballNumber computer = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber player = new BaseballNumber(List.of(3, 2, 6));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        baseballResult.showResult();
        Assertions.assertThat("1볼 1스트라이크").isEqualTo(out.toString().trim());
    }

    @Test
    void showResultNothingTest() {
        BaseballNumber computer = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber player = new BaseballNumber(List.of(4, 5, 6));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        baseballResult.showResult();
        Assertions.assertThat("낫싱").isEqualTo(out.toString().trim());
    }

    @Test
    void isThreeStrikeTest() {
        BaseballNumber computer = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber player = new BaseballNumber(List.of(1, 2, 3));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        baseballResult.isThreeStrike();
        Assertions.assertThat(baseballResult.isThreeStrike()).isEqualTo(true);
    }

    @Test
    void isThreeStrikeFailTest() {
        BaseballNumber computer = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber player = new BaseballNumber(List.of(4, 2, 3));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        baseballResult.isThreeStrike();
        Assertions.assertThat(baseballResult.isThreeStrike()).isEqualTo(false);
    }
}