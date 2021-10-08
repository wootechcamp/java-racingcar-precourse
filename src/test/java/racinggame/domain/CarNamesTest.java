package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNamesTest {

    @ParameterizedTest(name = "[{argumentsWithNames}] 자동차의 이름은 쉼표를 기준으로 구분해 만들수 있다")
    @ValueSource(strings = {"티볼리,제네시스,소울,레이"})
    void 자동차의_이름은_쉼표를_기준으로_구분해_만들수_있다(String namesWithComma) {
        final CarNames carNames = new CarNames(namesWithComma);

        assertThat(carNames.get()).containsAll(new CarNames(namesWithComma).get());
    }
}