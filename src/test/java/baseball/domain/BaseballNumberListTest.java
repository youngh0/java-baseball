package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BaseballNumberList의 무조건 3이다.")
class BaseballNumberListTest {
    @Test
    void 리스트의_크기가_3초과라면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class,
                () -> new BaseballNumberList(List.of(1, 3, 4, 5)));
    }

    @Test
    void 리스트의_크기가_3미만이라면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class,
                () -> new BaseballNumberList(List.of(1, 3)));
    }
}