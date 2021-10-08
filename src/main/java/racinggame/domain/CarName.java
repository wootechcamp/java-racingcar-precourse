package racinggame.domain;

import java.util.Objects;

public class CarName {

    private final String name;

    public CarName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CarName))
            return false;
        CarName carName = (CarName)o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
