package racinggame.domain;

import java.util.Objects;
import racinggame.exception.IllegalCarNameException;

public class CarName {
    public static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        verifyCarName(name);

        this.name = name;
    }

    private void verifyCarName(String name) {
        if (isNotLesserThanMaximumNameLength(name)) {
            throw new IllegalCarNameException();
        }
    }

    private boolean isNotLesserThanMaximumNameLength(String name) {
        return MAXIMUM_NAME_LENGTH < name.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarName)) {
            return false;
        }
        CarName carName = (CarName)o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
