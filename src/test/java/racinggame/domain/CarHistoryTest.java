package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

class CarHistoryTest {

    @ParameterizedTest(name = "[{argumentsWithNames}] 자동차의 히스토리를 기록하고 로드할수있다")
    @ValueSource(strings = {"티볼리,제네시스,소울,레이"})
    void 자동차의_히스토리를_기록하고_로드할수있다(final String namesWithComma) {
        final CarNames carNames = new CarNames(namesWithComma);
        final Cars cars = new Cars(carNames);

        final CarHistory carHistory = new CarHistory();
        carHistory.record(cars);

        final String load = carHistory.load();

        assertThat(load).contains("티볼리", "제네시스", "소울", "레이");
    }

    @Test
    void 자동차의_히스토리에서_우승자를_구할수있다() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(2, 4, 3, 4, 3);
        }

        final String namesWithComma = "티볼리,제네시스";
        final CarNames carNames = new CarNames(namesWithComma);
        final Cars cars = new Cars(carNames);

        final CarHistory carHistory = new CarHistory();
        carHistory.record(cars);

        final String winners = carHistory.getWinners();

        assertThat(winners).containsOnlyOnce("티볼리").containsIgnoringCase("제네시스");
    }
}