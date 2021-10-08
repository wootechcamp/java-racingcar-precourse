package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
    public static final String NAME_DELIMITER = ",";

    private final List<CarName> carNames;

    public CarNames(String namesWithComma) {
        this.carNames = convert(namesWithComma);
    }

    public List<CarName> get() {
        return carNames;
    }

    private List<CarName> convert(String namesWithComma) {
        final List<CarName> carNames = new ArrayList<>();
        final String[] names = namesWithComma.split(NAME_DELIMITER);

        for (String name : names) {
            carNames.add(new CarName(name));
        }

        return carNames;
    }
}
