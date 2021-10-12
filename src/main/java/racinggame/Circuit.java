package racinggame;

import racinggame.component.GameStateManager;
import racinggame.component.NumberGenerator;
import racinggame.domain.CarHistory;
import racinggame.domain.CarNames;
import racinggame.domain.Cars;
import racinggame.domain.Lap;
import racinggame.domain.Laps;
import racinggame.exception.RacingGameRuntimeException;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class Circuit {
    private final GameStateManager stateController;
    private final NumberGenerator numberGenerator;
    private final CarHistory carHistory;

    public Circuit(final GameStateManager stateController, final CarHistory carHistory,
        final NumberGenerator numberGenerator) {
        this.stateController = stateController;
        this.carHistory = carHistory;
        this.numberGenerator = numberGenerator;

        this.stateController.readyGame();
    }

    public void run() {
        stateController.startGame();

        while (stateController.isSustainable()) {
            racing();
        }
    }

    private void racing() {
        try {
            final CarNames carNames = InputView.readCarNames();
            final Laps laps = InputView.readLaps();

            round(laps, carNames);

            stateController.terminateGame();
        } catch (final RacingGameRuntimeException e) {
            OutputView.printError(e);
        }
    }

    private void round(final Laps laps, final CarNames carNames) {
        final Cars cars = new Cars(carNames);

        OutputView.lineSeparator();
        OutputView.printMessage("실행 결과");

        for (Lap ignored : laps.get()) {
            carHistory.record(cars.move(numberGenerator));

            OutputView.printMessage(carHistory.load());
            OutputView.lineSeparator();
        }

        OutputView.printMessage(carHistory.getWinners());
    }
}
