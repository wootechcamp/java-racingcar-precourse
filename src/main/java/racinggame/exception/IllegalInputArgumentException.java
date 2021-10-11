package racinggame.exception;

public class IllegalInputArgumentException extends RacingGameRuntimeException {
    public IllegalInputArgumentException(final String message) {
        super(message);
    }

    public IllegalInputArgumentException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
