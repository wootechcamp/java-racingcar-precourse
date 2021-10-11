package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.NotAllowNegativeException;

class CarDistanceTest {

    @Test
    void 자동차의_이동거리는_음수일_수_없다() {
        assertThatExceptionOfType(NotAllowNegativeException.class)
            .isThrownBy(() -> CarDistance.newInstance().add(-1))
            .withMessageContainingAll("[ERROR]", "음수");
    }

    @ParameterizedTest(name = "[{argumentsWithNames}] 자동차는 숫자가 4이상이면 전진한다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차는_숫자가_4이상이면_전진한다(int number) {
        final CarDistance carDistance = CarDistance.newInstance();
        carDistance.add(number);

        assertThat(carDistance.get()).isGreaterThan(0);
    }

    @ParameterizedTest(name = "[{argumentsWithNames}] 자동차는 숫자가 3이하이면 정지한다")
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차는_숫자가_3이하이면_정지한다(int number) {
        final CarDistance carDistance = CarDistance.newInstance();
        carDistance.add(number);

        assertThat(carDistance.get()).isEqualTo(0);
    }
}