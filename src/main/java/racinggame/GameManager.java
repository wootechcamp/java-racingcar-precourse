package racinggame;

import racinggame.component.NumberGenerator;
import racinggame.domain.Car;
import racinggame.domain.CarNames;
import racinggame.domain.Cars;
import racinggame.domain.Lap;
import racinggame.domain.Laps;
import racinggame.exception.RacingGameRuntimeException;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class GameManager {
    private final NumberGenerator numberGenerator;
    private final RacingReporter racingReporter;

    public GameManager(final NumberGenerator numberGenerator, final RacingReporter racingReporter) {
        this.numberGenerator = numberGenerator;
        this.racingReporter = racingReporter;

        RemoteController.readyGame();
    }

    public void start() {
        RemoteController.startGame();

        while (RemoteController.isSustainable()) {
            racing();
        }
    }

    private void racing() {
        try {
            final CarNames carNames = InputView.readCarNames();
            final Laps laps = InputView.readLaps();

            round(laps, carNames);

            RemoteController.terminateGame();
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
