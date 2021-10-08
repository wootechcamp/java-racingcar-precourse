package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import racinggame.component.NumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(CarNames carNames, NumberGenerator numberGenerator) {
        this.cars = carsOf(carNames, numberGenerator);
    }

    public List<Car> get() {
        return cars;
    }

    private List<Car> carsOf(CarNames carNames, NumberGenerator numberGenerator) {
        final List<Car> cars = new ArrayList<>();

        for (final CarName carName : carNames.get()) {
            cars.add(new Car(carName, new CarDistance(numberGenerator.generate())));
        }

        return cars;
    }
}
