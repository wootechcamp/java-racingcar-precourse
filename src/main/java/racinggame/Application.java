package racinggame;

import racinggame.component.GameStateController;
import racinggame.component.NumberGenerator;
import racinggame.component.RandomNumberGenerator;
import racinggame.domain.CarHistory;

public class Application {
    public static void main(String[] args) {
        final GameStateController stateController = new GameStateController();
        final CarHistory carHistory = new CarHistory();
        final NumberGenerator numberGenerator = new RandomNumberGenerator();

        final Circuit circuit = new Circuit(stateController, carHistory, numberGenerator);
        circuit.run();
    }
}
