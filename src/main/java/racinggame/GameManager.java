package racinggame;

import racinggame.component.NumberGenerator;
import racinggame.domain.Car;
import racinggame.domain.CarNames;
import racinggame.domain.Cars;
import racinggame.enums.GameStatus;
import racinggame.exception.RacingGameRuntimeException;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class GameManager {
    private static GameStatus gameStatus;

    private final NumberGenerator generator;
    private final RacingReporter racingReporter;

    public GameManager(final NumberGenerator generator, final RacingReporter racingReporter) {
        this.generator = generator;
        this.racingReporter = racingReporter;

        readyGame();
    }

    public void start() {
        startGame();

        while (gameStatus.isSustainable()) {
            racing();
        }
    }

    private void racing() {
        try {
            final CarNames carNames = InputView.readCarNames();
            final int readLaps = InputView.readLaps();

            round(readLaps, carNames);
            terminateGame();
        } catch (final RacingGameRuntimeException e) {
            OutputView.printError(e);
        }
    }

    private void round(final int laps, final CarNames carNames) {
        final Cars cars = new Cars(carNames);

        OutputView.lineSeparator();
        OutputView.printMessage("실행 결과");

        for (int lap = 0; lap < laps; lap++) {
            racingPerLap(cars);

            OutputView.lineSeparator();
        }

        racingReporter.prizeToWinners(cars);
    }

    private void racingPerLap(final Cars cars) {
        for (Car car : cars.get()) {
            car.move(generator.generate());

            racingReporter.analyze(car);
        }
    }

    private void readyGame() {
        gameStatus = GameStatus.READY;
    }

    private void startGame() {
        gameStatus = GameStatus.START;
    }

    private void terminateGame() {
        gameStatus = GameStatus.TERMINATE;
    }
}
