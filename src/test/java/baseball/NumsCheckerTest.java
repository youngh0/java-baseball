package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

@DisplayName("player입력 유효성 검사")
class NumsCheckerTest {
    @Test
    @DisplayName("player입력은 1~9까지의 서로 다른 3자리 수로 이루어진다.")
    void checkNumsValidationTest() {
        NumsChecker numsChecker = new NumsChecker();
        String verifyData = "132";
        assertThat(numsChecker.checkNumsValidation(verifyData)).isEqualTo(true);
    }
    @Test
    @DisplayName("player입력이 2자리면 잘못된 입력이다.")
    void checkNumsValidation2DigitsExceptionTest() {
        NumsChecker numsChecker = new NumsChecker();
        String verifyData = "12";
        assertThat(numsChecker.checkNumsValidation(verifyData)).isEqualTo(false);
    }
    @Test
    @DisplayName("player입력이 4자리면 잘못된 입력이다.")
    void checkNumsValidation4DigitsExceptionTest() {
        NumsChecker numsChecker = new NumsChecker();
        String verifyData = "1247";
        assertThat(numsChecker.checkNumsValidation(verifyData)).isEqualTo(false);
    }
    @Test
    @DisplayName("player입력에 숫자가 아닌 것이 있으면 잘못된 입력이다.")
    void checkNumsValidationNotOnlyDigitsExceptionTest() {
        NumsChecker numsChecker = new NumsChecker();
        String verifyData = "12 ";
        assertThat(numsChecker.checkNumsValidation(verifyData)).isEqualTo(false);
    }


}