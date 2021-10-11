package racinggame.util;

import racinggame.exception.IllegalInputArgumentException;

public final class Numbers {

    private Numbers() {
    }

    public static boolean isNegative(final Number number) {
        return number.intValue() < 0;
    }

    public static int parseInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalInputArgumentException("숫자만 입력할 수 있습니다.", e);
        }
    }
}
