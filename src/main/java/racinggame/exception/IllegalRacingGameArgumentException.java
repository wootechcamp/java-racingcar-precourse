package racinggame.exception;

public class IllegalRacingGameArgumentException extends RacingGameRuntimeException {
    public IllegalRacingGameArgumentException(final String message) {
        super(message);
    }

    public IllegalRacingGameArgumentException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
