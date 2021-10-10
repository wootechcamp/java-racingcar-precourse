package racinggame.view;

import nextstep.utils.Console;
import racinggame.exception.IllegalInputArgumentException;

public final class InputView {

    private InputView() {
    }

    public static int readLaps() {
        // TODO: 2021/10/10 Lap 이라는 객체를 만들어서 해당 객체에게 역할을 위임하는 것이 좋을 것 같음.
        try {
            OutputView.printMessage("시도할 회수는 몇회인가요?");

            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalInputArgumentException("숫자만 입력할 수 있습니다.", e);
        }
    }
}
