package baseball.validateInput;

import baseball.inputValidation.InputValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력 값 유효성 검사")
class InputValidationTest {
    InputValidation inputValidation = new InputValidation();

    @Nested
    class 게임_리플레이_입력_테스트 {
        @Test
        void _0이_들어오면_예외가_발생한다() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> inputValidation.validateReplayInputValidation("0"));
        }

        @Test
        void 문자나_특수문자가_들어오면_예외_발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> inputValidation.validateReplayInputValidation("_"));
        }

        @Test
        void 공백이_들어오면_예외_발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> inputValidation.validateReplayInputValidation(""));
        }

        @Test
        void 두_글자_이상_들어오면_예외_발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> inputValidation.validateReplayInputValidation("11"));
        }
    }
}