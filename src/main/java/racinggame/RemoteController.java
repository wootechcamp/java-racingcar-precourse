package racinggame;

import java.util.EnumSet;
import racinggame.enums.GameStatus;

public final class RemoteController {
    private static GameStatus gameStatus;

    private RemoteController() {
    }

    public static boolean isSustainable() {
        return EnumSet.of(GameStatus.READY, GameStatus.START).contains(gameStatus);
    }

    public static void readyGame() {
        gameStatus = GameStatus.READY;
    }

    public static void startGame() {
        gameStatus = GameStatus.START;
    }

    public static void terminateGame() {
        gameStatus = GameStatus.TERMINATE;
    }
}
