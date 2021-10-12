package racinggame.domain;

import java.text.MessageFormat;
import java.util.Objects;

public class Car {
    private final CarName carName;
    private CarDistance carDistance = CarDistance.newInstance();

    public Car(final CarName carName) {
        this.carName = carName;
    }

    public void move(final int number) {
        this.carDistance = carDistance.add(number);
    }

    public CarName getName() {
        return carName;
    }

    public CarDistance getDistance() {
        return carDistance;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        final Car car = (Car)o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} : {1}", carName, carDistance);
    }
}
