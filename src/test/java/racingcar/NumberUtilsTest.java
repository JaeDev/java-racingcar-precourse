package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NumberUtilsTest {

    @Test
    @DisplayName("두_수를_비교하여_큰수를_리턴한다")
    void 두_수를_비교하여_큰수를_리턴한다() {
        assertThat(NumberUtils.bigger(0,1)).isEqualTo(1);
        assertThat(NumberUtils.bigger(1,0)).isEqualTo(1);
    }
}
