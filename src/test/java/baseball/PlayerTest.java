package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    Player player = new Player();
    @Test
    @DisplayName("player가 정상적인 답을 입력하면 List<Integer>반환")
    void inputNumsTest() {
        InputStream in = new ByteArrayInputStream("132".getBytes());
        System.setIn(in);
        player = new Player();
        List<Integer> playerInputValue = new ArrayList<>(List.of(1, 3, 2));

        assertThat(player.inputAnswer()).isEqualTo(playerInputValue);
    }
    @Test
    @DisplayName("player가 답에 숫자가 아닌 것을 입력하면 IllegalArgumentException발생")
    void inputNumsNotDigitExceptionTest() {
        InputStream in = new ByteArrayInputStream("13 ".getBytes());
        System.setIn(in);
        player = new Player();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> player.inputAnswer());
    }
    @Test
    @DisplayName("player의 입력 답이 2자리 이하면 IllegalArgumentException발생")
    void inputNumsLess3ExceptionTest() {
        InputStream in = new ByteArrayInputStream("13".getBytes());
        System.setIn(in);
        player = new Player();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> player.inputAnswer());
    }
    @Test
    @DisplayName("player의 입력 답이 4자리 이상이면 IllegalArgumentException발생")
    void inputNumsOver3ExceptionTest() {
        InputStream in = new ByteArrayInputStream("1377".getBytes());
        System.setIn(in);
        player = new Player();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> player.inputAnswer());
    }
}