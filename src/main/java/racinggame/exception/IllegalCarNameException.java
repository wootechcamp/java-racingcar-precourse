package racinggame.exception;

import static java.text.MessageFormat.*;
import racinggame.domain.CarName;

public class IllegalCarNameException extends RacingGameRuntimeException {
    private static final String MESSAGE = format("자동차 이름은 {0}자 이하만 사용가능합니다.", CarName.MAXIMUM_NAME_LENGTH);

    public IllegalCarNameException() {
        super(MESSAGE);
    }

    public IllegalCarNameException(final Throwable cause) {
        super(MESSAGE, cause);
    }
}
