package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import racinggame.exception.NotAllowNegativeException;
import racinggame.util.Numbers;

public class Laps {
    private final List<Lap> laps;

    public Laps(final int inputLaps) {
        this.laps = lapsOf(inputLaps);
    }

    public List<Lap> get() {
        return laps;
    }

    private List<Lap> lapsOf(final int inputLaps) {
        verifyLaps(inputLaps);

        final List<Lap> laps = new ArrayList<>();

        for (int lap = 0; lap < inputLaps; lap++) {
            laps.add(new Lap(lap));
        }

        return laps;
    }

    private void verifyLaps(final int inputLaps) {
        if (Numbers.isNegative(inputLaps)) {
            throw new NotAllowNegativeException("시도회수");
        }
    }
}
