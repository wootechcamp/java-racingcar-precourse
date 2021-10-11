package racinggame;

import java.util.StringJoiner;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.view.OutputView;

public class RacingReporter {
    private static int maximumDistance = 0;

    public RacingReporter() {
    }

    public void analyze(Car car) {
        OutputView.printMessage(car.toString());

        maximumDistance = Math.max(maximumDistance, car.getDistance().get());
    }

    public void prizeToWinners(final Cars cars) {
        final StringJoiner prize = new StringJoiner(",", "최종 우승자는 ", " 입니다.");

        for (Car car : cars.get()) {
            joinWinner(prize, car);
        }

        OutputView.printMessage(prize.toString());
    }

    private void joinWinner(final StringJoiner prize, final Car car) {
        if (isNotJointAward(car)) {
            return;
        }

        prize.add(car.getName().toString());
    }

    private boolean isNotJointAward(Car car) {
        return car.getDistance().get() != maximumDistance;
    }
}
