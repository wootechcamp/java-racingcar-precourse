package racinggame.domain;

import java.util.StringJoiner;

public class CarHistory {
    private static int MAXIMUM_DISTANCE;

    private Cars cars;

    public void record(final Cars cars) {
        this.cars = cars;
    }

    public String load() {
        final StringJoiner load = new StringJoiner(System.lineSeparator());

        for (final Car car : cars.get()) {
            load.add(car.toString());

            MAXIMUM_DISTANCE = Math.max(MAXIMUM_DISTANCE, car.getDistance().get());
        }

        return load.toString();
    }

    public String getWinners() {
        final StringJoiner winner = new StringJoiner(",", "최종 우승자는 ", " 입니다.");

        for (final Car car : cars.get()) {
            joinWinner(winner, car);
        }

        return winner.toString();
    }

    private void joinWinner(final StringJoiner winner, final Car car) {
        if (isNotJointAward(car)) {
            return;
        }

        winner.add(car.getName().toString());
    }

    private boolean isNotJointAward(final Car car) {
        return car.getDistance().get() != MAXIMUM_DISTANCE;
    }
}
