package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.exception.IllegalCarNameException;

class CarTest {

    @ParameterizedTest(name = "[{argumentsWithNames}] 5자 이하의 이름이 있는 자동차를 생성할 수 있다")
    @CsvSource({
        "티볼리,Palisade", "제네시스,Lamborghini", "소울,Rolls-Royce", "레이,그란투리스모"
    })
    void _5자_이하의_이름이_있는_자동차를_생성할_수_있다(String validName, String invalidName) {
        assertThatNoException()
            .isThrownBy(() -> new Car(new CarName(validName)));

        assertThatExceptionOfType(IllegalCarNameException.class)
            .isThrownBy(() -> new Car(new CarName(invalidName)));
    }
}