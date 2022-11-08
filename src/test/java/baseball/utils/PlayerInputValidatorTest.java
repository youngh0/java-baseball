package baseball.utils;

import baseball.service.ProgressGameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayerInputValidatorTest {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator();
    ProgressGameService progressGameService = new ProgressGameService();

    @Test
    void 사용자_입력이_유효성_검사를_통과하면_리스트반환() {
        assertThat(playerInputValidator.validatePlayerAnswerInput("451"))
                .isEqualTo(List.of(4, 5, 1));
    }

    @Test
    void 사용자가_입력한_정답이_세글자가_아니면_예외발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> playerInputValidator.validatePlayerAnswerInput("1234"));
    }

    @Test
    void 사용자가_입력한_정답에_문자가_있다면_예외발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> playerInputValidator.validatePlayerAnswerInput("12"));
    }

    @Test
    void 사용자가_입력한_정답에_중복숫자가_있으면_예외발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> playerInputValidator.validatePlayerAnswerInput("313"));
    }
    @Nested
    class 사용자_재식작_입력_유효성검사{
        @Test
        void 재시작_입력에_1이_오면_true() {
            assertThat(progressGameService.endGame("1")).isEqualTo(true);
        }

        @Test
        void 재시작_입력에_2가_오면_false() {
            assertThat(progressGameService.endGame("2")).isEqualTo(false);
        }

        @Test
        void 재시작_입력에_두글자_이상이_오면_예외_발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> playerInputValidator.validateReplayInputValidation("1234"));
        }

        @Test
        void 재시작_입력에_아무것도_안오면_예외_발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> playerInputValidator.validateReplayInputValidation(""));
        }

        @Test
        void 재시작_입력에_문자가_오면_예외_발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> playerInputValidator.validateReplayInputValidation(" "));
        }

        @Test
        void 재시작_입력에_1_2를_제외한_숫자가_오면_예외_발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> playerInputValidator.validateReplayInputValidation("3"));
        }
    }
}