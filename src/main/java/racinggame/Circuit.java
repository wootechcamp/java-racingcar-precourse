package racinggame;

import racinggame.component.NumberGenerator;
import racinggame.component.RacingReporter;
import racinggame.component.GameStateController;
import racinggame.domain.Car;
import racinggame.domain.CarNames;
import racinggame.domain.Cars;
import racinggame.domain.Lap;
import racinggame.domain.Laps;
import racinggame.exception.RacingGameRuntimeException;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class Circuit {
    private final GameStateController stateController;
    private final RacingReporter racingReporter;
    private final NumberGenerator numberGenerator;

    public Circuit(final GameStateController stateController, final RacingReporter racingReporter, final NumberGenerator numberGenerator) {
        this.stateController = stateController;
        this.racingReporter = racingReporter;
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
            racingPerLap(cars);

            OutputView.lineSeparator();
        }

        racingReporter.prizeToWinners(cars);
    }

    private void racingPerLap(final Cars cars) {
        for (Car car : cars.get()) {
            car.move(numberGenerator.generate());

            racingReporter.analyze(car);
        }
    }
}
