package racinggame.exception;

public class IllegalCarDistanceStateException extends RacingGameRuntimeException {
    private static final String MESSAGE = "이동 할 수 없는 상태입니다. 생성 된 숫자에 문제가 있습니다.";

    public IllegalCarDistanceStateException() {
        super(MESSAGE);
    }
}
