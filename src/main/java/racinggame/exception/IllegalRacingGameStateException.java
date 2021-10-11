package racinggame.exception;

public class IllegalRacingGameStateException extends RacingGameRuntimeException {
    public IllegalRacingGameStateException(final String message) {
        super(message);
    }

    public IllegalRacingGameStateException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
