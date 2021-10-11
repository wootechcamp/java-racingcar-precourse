package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.NotAllowNegativeException;

class LapsTest {

    @ParameterizedTest(name = "[{argumentsWithNames}] 숫자로된 laps 값으로 Laps 객체를 생성할 수 있다")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 숫자로된_laps_값으로_Laps_객체를_생성할_수_있다(final int inputLaps) {
        final Laps laps = new Laps(inputLaps);

        assertThat(laps.get()).isEqualTo(new Laps(inputLaps).get());
    }

    @Test
    void 음수로된_laps_값으로_Laps_객체를_생성할_수_없다() {
        assertThatExceptionOfType(NotAllowNegativeException.class)
            .isThrownBy(() -> new Laps(-1))
            .withMessageContainingAll("[ERROR]", "음수");
    }
}