package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("nums 유효성 검사")
class NumsCheckerTest {
    @Nested
    @DisplayName("nums중복 숫자 검사")
    class DuplicateTest{
        @Test
        @DisplayName("3자리 숫자에 중복되는 숫자가 없다면 true")
        void checkIsNonDuplicateNumsTest() {
            NumsChecker numsChecker = new NumsChecker();
            List<Integer> checkData = new ArrayList<>(List.of(1, 3, 2));

            assertThat(numsChecker.checkIsNonDuplicateNums(checkData)).isEqualTo(true);
        }
        @Test
        @DisplayName("3자리 숫자에 중복되는 숫자가 있다면 false")
        void checkIsNonDuplicateNumsExceptionTest() {
            NumsChecker numsChecker = new NumsChecker();
            List<Integer> checkData = new ArrayList<>(List.of(1, 3, 3));

            assertThat(numsChecker.checkIsNonDuplicateNums(checkData)).isEqualTo(false);
        }
        @Test
        @DisplayName("3자리가 안된다면 false")
        void checkIsNonDuplicateNumsLessExceptionTest() {
            NumsChecker numsChecker = new NumsChecker();
            List<Integer> checkData = new ArrayList<>(List.of(1, 3));

            assertThat(numsChecker.checkIsNonDuplicateNums(checkData)).isEqualTo(false);
        }
        @Test
        @DisplayName("3자리가 넘는다면 false")
        void checkIsNonDuplicateNumsOverExceptionTest() {
            NumsChecker numsChecker = new NumsChecker();
            List<Integer> checkData = new ArrayList<>(List.of(1, 3, 4, 9));

            assertThat(numsChecker.checkIsNonDuplicateNums(checkData)).isEqualTo(false);
        }

    }




}