package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class RandomUtilsTest {

    @Test
    @DisplayName("랜덤값_0부터_9사이")
    void 랜덤값_0부터_9사이() {
        assertThat(RandomUtils.getRandomValue()).isGreaterThanOrEqualTo(0);
        assertThat(RandomUtils.getRandomValue()).isLessThanOrEqualTo(9);
    }
}
