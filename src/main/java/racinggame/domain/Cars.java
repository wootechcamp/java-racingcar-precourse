package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars implements Cloneable {
    private final List<Car> cars;

    public Cars(final CarNames carNames) {
        this.cars = carsOf(carNames);
    }

    public List<Car> get() {
        return cars;
    }

    private List<Car> carsOf(final CarNames carNames) {
        final List<Car> cars = new ArrayList<>();

        for (final CarName carName : carNames.get()) {
            cars.add(new Car(carName));
        }

        return cars;
    }
}
