package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

@DisplayName("player입력 유효성 검사")
class AnswerCheckerTest {
    AnswerChecker answerChecker = new AnswerChecker();
    @Test
    @DisplayName("player입력은 1~9까지의 서로 다른 3자리 수로 이루어진다.")
    void checkAnswerValidationTest() {
        answerChecker = new AnswerChecker();
        String verifyData = "132";
        assertThat(answerChecker.checkAnswerValidation(verifyData)).isEqualTo(true);
    }
    @Test
    @DisplayName("player입력이 2자리 이하면 잘못된 입력이다.")
    void checkAnswerValidation2DigitsExceptionTest() {
        answerChecker = new AnswerChecker();
        String verifyData = "12";
        assertThat(answerChecker.checkAnswerValidation(verifyData)).isEqualTo(false);
    }
    @Test
    @DisplayName("player입력이 4자리 이상이면 잘못된 입력이다.")
    void checkAnswerValidation4DigitsExceptionTest() {
        answerChecker = new AnswerChecker();
        String verifyData = "1247";
        assertThat(answerChecker.checkAnswerValidation(verifyData)).isEqualTo(false);
    }
    @Test
    @DisplayName("player입력에 숫자가 아닌 것이 있으면 잘못된 입력이다.")
    void checkAnswerValidationNotOnlyDigitsExceptionTest() {
        answerChecker = new AnswerChecker();
        String verifyData = "12 ";
        assertThat(answerChecker.checkAnswerValidation(verifyData)).isEqualTo(false);
    }
    @Test
    @DisplayName("player입력에 중복 숫자가 있으면 잘못된 입력이다.")
    void checkAnswerValidationDuplicateExceptionTest() {
        answerChecker = new AnswerChecker();
        String verifyData = "12 ";
        assertThat(answerChecker.checkAnswerValidation(verifyData)).isEqualTo(false);
    }


}