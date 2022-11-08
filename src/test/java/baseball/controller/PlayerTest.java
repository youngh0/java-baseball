package baseball.controller;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Player가 입력하는 정답 유효성 검사")
class PlayerTest extends NsTest {
    @Test
    @DisplayName("입력이 3글자가 아니면 예외가 발생한다.")
    void notThreeLengthExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력에 숫자가 아닌 문자가 있으면 예외가 발생한다.")
    void notOnlyDigitsExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" 34"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력에 0이 있으면 예외가 발생한다.")
    void zeroExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("중복되는 숫자가 있으면 예외가 발생한다.")
    void duplicateExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("414"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validInputTest() {
        Player player = new Player();
        List<Integer> integers = player.inputAnswer("126");
        Assertions.assertThat(integers).isEqualTo(List.of(1, 2, 6));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}