package racinggame.domain;

import racinggame.exception.IllegalCarDistanceStateException;
import racinggame.exception.NotAllowNegativeException;

public class CarDistance {
    public static final int MOVABLE_MINIMUM_NUMBER = 4;
    public static final int IMMOVABLE_MAXIMUM_NUMBER = 3;

    private final int distance;

    public CarDistance(int number) {
        verifyDistance(number);

        this.distance = judge(number);
    }

    public int get() {
        return distance;
    }

    private void verifyDistance(int number) {
        if (isNegative(number)) {
            throw new NotAllowNegativeException("자동차의 이동거리");
        }
    }

    private boolean isNegative(int number) {
        return number < 0;
    }

    private int judge(int number) {
        if (isMovable(number)) {
            return 1;
        }

        if (isImmovable(number)) {
            return 0;
        }

        throw new IllegalCarDistanceStateException();
    }

    private boolean isMovable(int number) {
        return number >= MOVABLE_MINIMUM_NUMBER;
    }

    private boolean isImmovable(int number) {
        return number <= IMMOVABLE_MAXIMUM_NUMBER;
    }
}
