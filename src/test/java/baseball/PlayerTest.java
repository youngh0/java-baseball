package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class PlayerTest {
    Player player = new Player();

    @Nested
    @DisplayName("Player정답 입력 예외 테스트")
    class baseballNumberStringConstructor {
        @Test
        @DisplayName("입력이 3글자가 아니면 예외가 발생한다.")
        void notThreeLengthExceptionTest() {
            InputStream in = new ByteArrayInputStream("1332".getBytes());
            System.setIn(in);
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> player.inputAnswer());
        }

        @Test
        @DisplayName("입력에 숫자가 아닌 문자가 있으면 예외가 발생한다.")
        void notOnlyDigitsExceptionTest() {
            InputStream in = new ByteArrayInputStream("1a2".getBytes());
            System.setIn(in);
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> player.inputAnswer());
        }

        @Test
        @DisplayName("입력에 0이 있으면 예외가 발생한다.")
        void zeroExceptionTest() {
            InputStream in = new ByteArrayInputStream("102".getBytes());
            System.setIn(in);
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> player.inputAnswer());
        }

        @Test
        @DisplayName("중복되는 숫자가 있으면 예외가 발생한다.")
        void duplicateExceptionTest() {
            InputStream in = new ByteArrayInputStream("133".getBytes());
            System.setIn(in);
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> player.inputAnswer());
        }
    }
}