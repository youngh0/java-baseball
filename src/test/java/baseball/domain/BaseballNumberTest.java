package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("BaseballNumber생성자 유효성, equals테스트")
class BaseballNumberTest {
    @Nested
    @DisplayName("1~9이루어져야 한다.")
    class baseballNumberValidation {
        @Test
        void _0은_예외발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new BaseballNumber(0));
        }

        @Test
        void _10은_예외발생() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new BaseballNumber(10));
        }
    }

    @Nested
    @DisplayName("equals검사")
    class baseballNumberStringConstructor {
        @Test
        @DisplayName("각각 1,2를 number로 가지는 baseballNumber의 equals는 false다.")
        void baseballNumberEqualsFalseTest() {
            BaseballNumber baseballNumber = new BaseballNumber(1);
            BaseballNumber baseballNumber1 = new BaseballNumber(2);
            assertThat(baseballNumber.equals(baseballNumber1)).isEqualTo(false);
        }

        @Test
        @DisplayName("각각 1,1을 number로 가지는 baseballNumber의 equals는 true다.")
        void notOnlyDigitsExceptionTest() {
            BaseballNumber baseballNumber = new BaseballNumber(1);
            BaseballNumber baseballNumber1 = new BaseballNumber(1);
            assertThat(baseballNumber.equals(baseballNumber1)).isEqualTo(true);
        }
    }
}