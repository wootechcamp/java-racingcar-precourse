package racinggame;

import racinggame.component.GameStateController;
import racinggame.component.NumberGenerator;
import racinggame.component.RacingReporter;
import racinggame.component.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        final GameStateController stateController = new GameStateController();
        final RacingReporter racingReporter = new RacingReporter();
        final NumberGenerator numberGenerator = new RandomNumberGenerator();

        final Circuit circuit = new Circuit(stateController, racingReporter, numberGenerator);
        circuit.run();
    }
}
