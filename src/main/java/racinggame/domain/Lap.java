package racinggame.domain;

import java.util.Objects;
import racinggame.exception.NotAllowNegativeException;
import racinggame.util.Numbers;

public class Lap {
    private final int lap;

    public Lap(final int lap) {
        verifyLap(lap);

        this.lap = lap;
    }

    public int get() {
        return lap;
    }

    private void verifyLap(final int lap) {
        if (Numbers.isNegative(lap)) {
            throw new NotAllowNegativeException("시도할 회수");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lap)) {
            return false;
        }
        final Lap lap1 = (Lap)o;
        return lap == lap1.lap;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lap);
    }
}
