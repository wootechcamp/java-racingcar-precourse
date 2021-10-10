package racinggame.exception;

import static java.text.MessageFormat.*;

public class NotAllowNegativeException extends RacingGameRuntimeException {
    private static final String MESSAGE_PATTERN = "{0}은/는 음수가 올 수 없습니다.";

    public NotAllowNegativeException(final String message) {
        super(format(MESSAGE_PATTERN, message));
    }

    public NotAllowNegativeException(final String message, final Throwable cause) {
        super(format(MESSAGE_PATTERN, message), cause);
    }
}
