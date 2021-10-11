package racinggame;

import racinggame.component.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        final GameManager gameManager = new GameManager(new RandomNumberGenerator(), new RacingReporter());
        gameManager.start();
    }
}
