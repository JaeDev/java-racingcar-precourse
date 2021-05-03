package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidateUtilsTest {

    @Test
    @DisplayName("자동차_이름_입력값_유효성_확인: 차량이 1대인 경우 재입력")
    void 자동차_이름_입력값_유효성_확인_차량이_1대인_경우() {
        assertThat(ValidateUtils.validateCarNames("qwert")).isEqualTo(false);
        assertThat(ValidateUtils.validateCarNames("qwert, asdf")).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차_이름_입력값_유효성_확인: 차량 이름이 5자가 넘는 경우 재입력")
    void 자동차_이름_입력값_유효성_확인_차량_이름이_5자가_넘는_경우() {
        assertThat(ValidateUtils.validateCarNames("qwerty")).isEqualTo(false);
        assertThat(ValidateUtils.validateCarNames("qwert, asdfgh")).isEqualTo(false);
        assertThat(ValidateUtils.validateCarNames("qwer, asdf")).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차_이름_입력값_유효성_확인: 차량 이름이 5자가 넘는 경우 재입력")
    void 자동차_이름_입력값_유효성_확인_차량_이름이_동일한_경우() {
        assertThat(ValidateUtils.validateCarNames("qwert, qwert")).isEqualTo(false);
        assertThat(ValidateUtils.validateCarNames("qwert, qwer")).isEqualTo(true);
    }
    @Test
    @DisplayName("자동차_이름_입력값_유효성_확인: 기타")
    void 자동차_이름_입력값_유효성_확인_기타() {
        assertThat(ValidateUtils.validateCarNames("qwert, asdf, ")).isEqualTo(false);
        assertThat(ValidateUtils.validateCarNames(",")).isEqualTo(false);
        assertThat(ValidateUtils.validateCarNames(" , ")).isEqualTo(false);
        assertThat(ValidateUtils.validateCarNames("qwer, asdf")).isEqualTo(true);
    }
}
