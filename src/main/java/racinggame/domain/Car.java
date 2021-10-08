package racinggame.domain;

import java.util.Objects;

public class Car {
    private final CarName carName;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public CarName getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car)o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
