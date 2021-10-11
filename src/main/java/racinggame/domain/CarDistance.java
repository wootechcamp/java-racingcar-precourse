package racinggame.domain;

import java.util.StringJoiner;
import racinggame.exception.IllegalCarDistanceStateException;
import racinggame.exception.NotAllowNegativeException;
import racinggame.util.Numbers;

public class CarDistance {
    public static final int MOVABLE_MINIMUM_NUMBER = 4;
    public static final int IMMOVABLE_MAXIMUM_NUMBER = 3;

    private int distance;

    private CarDistance(int distance) {
        this.distance = distance;
    }

    public static CarDistance newInstance() {
        return new CarDistance(0);
    }

    public void add(final int number) {
        verifyDistance(number);

        distance += judge(number);
    }

    public int get() {
        return distance;
    }

    private void verifyDistance(final int number) {
        if (Numbers.isNegative(number)) {
            throw new NotAllowNegativeException("자동차의 이동거리");
        }
    }

    private int judge(final int number) {
        if (isMovable(number)) {
            return 1;
        }

        if (isImmovable(number)) {
            return 0;
        }

        throw new IllegalCarDistanceStateException();
    }

    private boolean isMovable(final int number) {
        return number >= MOVABLE_MINIMUM_NUMBER;
    }

    private boolean isImmovable(final int number) {
        return number <= IMMOVABLE_MAXIMUM_NUMBER;
    }

    private String toHyphen() {
        final StringJoiner joiner = new StringJoiner("");

        for (int i = 0; i < distance; i++) {
            joiner.add("-");
        }

        return joiner.toString();
    }

    @Override
    public String toString() {
        return toHyphen();
    }
}
