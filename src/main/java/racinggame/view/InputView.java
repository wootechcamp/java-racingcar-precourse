package racinggame.view;

import nextstep.utils.Console;
import racinggame.domain.CarNames;
import racinggame.exception.NotAllowNegativeException;
import racinggame.util.Numbers;

public final class InputView {

    private InputView() {
    }

    public static int readLaps() {
        OutputView.printMessage("시도할 회수는 몇회인가요?");

        final String readLine = Console.readLine();
        final int laps = Numbers.parseInt(readLine);

        verifyLaps(laps);

        return laps;
    }

    public static CarNames readCarNames() {
        OutputView.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");

        return new CarNames(Console.readLine());
    }

    private static void verifyLaps(final int laps) {
        if (Numbers.isNegative(laps)) {
            throw new NotAllowNegativeException("시도할 회수");
        }
    }
}
