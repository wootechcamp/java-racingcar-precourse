package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.component.NumberGenerator;
import racinggame.component.RandomNumberGenerator;

class CarsTest {

    @ParameterizedTest(name = "[{argumentsWithNames}] CarNames 가지고 Cars 일급컬렉션을 만든다")
    @ValueSource(strings = {
        "티볼리,제네시스,소울,레이",
        "쏘렌토,알페온,스포티지,지바겐"
    })
    void CarNames_가지고_Cars_일급컬렉션을_만든다(String namesWithComma) {
        final NumberGenerator numberGenerator = new RandomNumberGenerator();
        final Cars cars = new Cars(new CarNames(namesWithComma), numberGenerator);

        assertThat(cars.get()).containsAll(new Cars(new CarNames(namesWithComma), numberGenerator).get());
    }
}