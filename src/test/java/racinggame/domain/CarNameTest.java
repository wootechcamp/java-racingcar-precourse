package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @ParameterizedTest(name = "[{argumentsWithNames}] 자동차의 이름을 가지고 있는 CarName 클래스를 생성할 수 있다")
    @ValueSource(strings = {"티볼리", "제네시스", "소울", "레이"})
    void 자동차의_이름을_가지고_있는_CarName_클래스를_생성할_수_있다(String name) {
        final CarName carName = new CarName(name);

        assertThat(carName).isEqualTo(new CarName(name));
    }
}