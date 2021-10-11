package racinggame.util;

import racinggame.exception.IllegalRacingGameArgumentException;

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
            throw new IllegalRacingGameArgumentException("숫자로 된 문자열만 허용합니다.", e);
        }
    }
}
