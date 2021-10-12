package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import racinggame.component.NumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(final CarNames carNames) {
        this.cars = carsOf(carNames);
    }

    public Cars move(final NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }

        return this;
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
