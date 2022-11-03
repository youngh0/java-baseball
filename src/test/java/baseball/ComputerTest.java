package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    @DisplayName("컴퓨터는 3자리의 서로 다른 수를 난수를 생성한다.")
    void generateRandomNumsTest() {
        Computer computer = new Computer();
        List<Integer> integers = computer.generateRandomNums();

        long numCount = integers.stream()
                .distinct()
                .count();
        Assertions.assertThat(numCount).isEqualTo(3);
    }
}