package racinggame.domain;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private final CarDistance carDistance;

    public Car(final CarName carName, final CarDistance carDistance) {
        this.carName = carName;
        this.carDistance = carDistance;
    }

    public CarName getCarName() {
        return carName;
    }

    public CarDistance getCarDistance() {
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
}
