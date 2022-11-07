package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("게임 결과 출력 및 3스트라이크 여부 테스트")
class BaseballResultTest {
    @Test
    void 쓰리스트라이크_테스트() {
        BaseballNumberList computer = new BaseballNumberList(List.of(1, 2, 3));
        List<Integer> player = new ArrayList<>(List.of(1, 2, 3));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        int strikeCount = baseballResult.getStrikeCount();
        int ballCount = baseballResult.getBallCount();

        int answerStrike = 3;
        int answerBall = 0;
        assertThat(strikeCount == answerStrike && ballCount == answerBall).isEqualTo(true);
    }

    @Test
    void 볼_테스트() {
        BaseballNumberList computer = new BaseballNumberList(List.of(1, 2, 3));
        List<Integer> player = new ArrayList<>(List.of(4, 3, 5));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        int strikeCount = baseballResult.getStrikeCount();
        int ballCount = baseballResult.getBallCount();

        int answerStrike = 0;
        int answerBall = 1;
        assertThat(strikeCount == answerStrike && ballCount == answerBall).isEqualTo(true);
    }

    @Test
    void 볼_스트라이크_섞인_결과_테스트() {
        BaseballNumberList computer = new BaseballNumberList(List.of(1, 2, 3));
        List<Integer> player = new ArrayList<>(List.of(3, 2, 6));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        int strikeCount = baseballResult.getStrikeCount();
        int ballCount = baseballResult.getBallCount();

        int answerStrike = 1;
        int answerBall = 1;
        assertThat(strikeCount == answerStrike && ballCount == answerBall).isEqualTo(true);
    }

    @Test
    void 낫싱_테스트() {
        BaseballNumberList computer = new BaseballNumberList(List.of(1, 2, 3));
        List<Integer> player = new ArrayList<>(List.of(4, 5, 6));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        int strikeCount = baseballResult.getStrikeCount();
        int ballCount = baseballResult.getBallCount();

        int answerStrike = 0;
        int answerBall = 0;
        assertThat(strikeCount == answerStrike && ballCount == answerBall).isEqualTo(true);
    }

    @Test
    void 쓰리스트라이크_여부_테스트() {
        BaseballNumberList computer = new BaseballNumberList(List.of(1, 2, 3));
        List<Integer> player = new ArrayList<>(List.of(1, 2, 3));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        baseballResult.isThreeStrike();
        assertThat(baseballResult.isThreeStrike()).isEqualTo(true);
    }

    @Test
    void 낫쓰리스트라이크_테스트() {
        BaseballNumberList computer = new BaseballNumberList(List.of(1, 2, 3));
        List<Integer> player = new ArrayList<>(List.of(4, 2, 3));

        BaseballResult baseballResult = computer.judgeBaseballResult(player);
        baseballResult.isThreeStrike();
        assertThat(baseballResult.isThreeStrike()).isEqualTo(false);
    }
}