package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.IllegalCarNameException;

class CarNameTest {

    @ParameterizedTest(name = "[{argumentsWithNames}] 자동차의 이름을 가지고 있는 CarName 클래스를 생성할 수 있다")
    @ValueSource(strings = {"티볼리", "제네시스", "소울", "레이"})
    void 자동차의_이름을_가지고_있는_CarName_클래스를_생성할_수_있다(String name) {
        final CarName carName = new CarName(name);

        assertThat(carName).isEqualTo(new CarName(name));
    }

    @ParameterizedTest(name = "[{argumentsWithNames}] CarName 의 name 은 5자 이하여야 하고 이를 위반하면 에러메시지가 ERROR 로 시작하는 예외가 발생한다")
    @ValueSource(strings = {"Palisade", "Lamborghini", "Rolls-Royce", "그란투리스모"})
    void CarName_의_name_은_5자_이하여야_하고_이를_위반하면_에러메시지가_ERROR_로_시작하는_예외가_발생한다(String name) {
        assertThatExceptionOfType(IllegalCarNameException.class)
            .isThrownBy(() -> new CarName(name))
            .withMessageContaining("[ERROR]");
    }
}