package baseball.domain;

import baseball.domain.BaseballNumberList;
import baseball.domain.BaseballResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

@DisplayName("게임 결과 출력 및 3스트라이크 여부 테스트")
class BaseballResultTest {
    OutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
    }

    @Test
    void 쓰리스트라이크_출력_테스트() {
        BaseballNumberList computer = new BaseballNumberList(List.of(1, 2, 3));
        BaseballNumberList player = new BaseballNumberList(List.of(1, 2, 3));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        baseballResult.showResult();
        Assertions.assertThat(out.toString().trim()).isEqualTo("3스트라이크");
    }

    @Test
    void 볼만_있는_출력_테스트() {
        BaseballNumberList computer = new BaseballNumberList(List.of(1, 2, 3));
        BaseballNumberList player = new BaseballNumberList(List.of(4, 3, 5));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        baseballResult.showResult();
        Assertions.assertThat("1볼").isEqualTo(out.toString().trim());
    }

    @Test
    void 볼_스트라이크_섞인_결과_출력_테스트() {
        BaseballNumberList computer = new BaseballNumberList(List.of(1, 2, 3));
        BaseballNumberList player = new BaseballNumberList(List.of(3, 2, 6));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        baseballResult.showResult();
        Assertions.assertThat("1볼 1스트라이크").isEqualTo(out.toString().trim());
    }

    @Test
    void 낫싱_출력_테스트() {
        BaseballNumberList computer = new BaseballNumberList(List.of(1, 2, 3));
        BaseballNumberList player = new BaseballNumberList(List.of(4, 5, 6));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        baseballResult.showResult();
        Assertions.assertThat("낫싱").isEqualTo(out.toString().trim());
    }

    @Test
    void 쓰리스트라이크_여부_테스트() {
        BaseballNumberList computer = new BaseballNumberList(List.of(1, 2, 3));
        BaseballNumberList player = new BaseballNumberList(List.of(1, 2, 3));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        baseballResult.isThreeStrike();
        Assertions.assertThat(baseballResult.isThreeStrike()).isEqualTo(true);
    }

    @Test
    void 쓰리스트라이크_false_테스트() {
        BaseballNumberList computer = new BaseballNumberList(List.of(1, 2, 3));
        BaseballNumberList player = new BaseballNumberList(List.of(4, 2, 3));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        baseballResult.isThreeStrike();
        Assertions.assertThat(baseballResult.isThreeStrike()).isEqualTo(false);
    }
}