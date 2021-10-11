package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.NotAllowNegativeException;

class LapTest {

    @ParameterizedTest(name = "[{argumentsWithNames}] 시도회수로 Lap 객체를 만들 수 있다")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 시도회수로_Lap_객체를_만들_수_있다(final int inputLap) {
        final Lap lap = new Lap(inputLap);

        assertThat(lap).isEqualTo(new Lap(inputLap));
    }

    @Test
    void 시도회수는_음수가_올_수_없다() {
        assertThatExceptionOfType(NotAllowNegativeException.class)
            .isThrownBy(() -> new Lap(-1))
            .withMessageContainingAll("[ERROR]", "음수");
    }
}