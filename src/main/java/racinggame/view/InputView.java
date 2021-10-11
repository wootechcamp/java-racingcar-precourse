package racinggame.view;

import nextstep.utils.Console;
import racinggame.domain.CarNames;
import racinggame.domain.Laps;
import racinggame.util.Numbers;

public final class InputView {

    private InputView() {
    }

    public static Laps readLaps() {
        OutputView.printMessage("시도할 회수는 몇회인가요?");

        final String readLine = Console.readLine();
        final int laps = Numbers.parseInt(readLine);

        return new Laps(laps);
    }

    public static CarNames readCarNames() {
        OutputView.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");

        return new CarNames(Console.readLine());
    }
}
