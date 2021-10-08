package racinggame.exception;

import static java.text.MessageFormat.*;

public class RacingGameRuntimeException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "레이싱 게임 중 오류가 발생했습니다.";
    private static final String MESSAGE_PATTERN = "[ERROR] {0}";

    public RacingGameRuntimeException() {
        super(format(MESSAGE_PATTERN, DEFAULT_MESSAGE));
    }

    public RacingGameRuntimeException(String message) {
        super(format(MESSAGE_PATTERN, message));
    }

    public RacingGameRuntimeException(String message, Throwable cause) {
        super(format(MESSAGE_PATTERN, message), cause);
    }

    public RacingGameRuntimeException(Throwable cause) {
        super(format(MESSAGE_PATTERN, DEFAULT_MESSAGE), cause);
    }

    public RacingGameRuntimeException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(format(MESSAGE_PATTERN, message), cause, enableSuppression, writableStackTrace);
    }
}
