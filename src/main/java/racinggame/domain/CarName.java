package racinggame.domain;

import java.util.Objects;
import racinggame.exception.IllegalCarNameException;

public class CarName {
    public static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public CarName(final String name) {
        verifyCarName(name);

        this.name = name;
    }

    private void verifyCarName(final String name) {
        if (isNotLesserThanMaximumNameLength(name)) {
            throw new IllegalCarNameException();
        }
    }

    private boolean isNotLesserThanMaximumNameLength(final String name) {
        return MAXIMUM_NAME_LENGTH < name.length();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarName)) {
            return false;
        }
        final CarName carName = (CarName)o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
