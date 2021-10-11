package racinggame.component;

import java.util.EnumSet;
import racinggame.enums.GameStatus;

public class GameStateController {
    private static GameStatus gameStatus;

    public boolean isSustainable() {
        return EnumSet.of(GameStatus.READY, GameStatus.START).contains(gameStatus);
    }

    public void readyGame() {
        gameStatus = GameStatus.READY;
    }

    public void startGame() {
        gameStatus = GameStatus.START;
    }

    public void terminateGame() {
        gameStatus = GameStatus.TERMINATE;
    }
}
