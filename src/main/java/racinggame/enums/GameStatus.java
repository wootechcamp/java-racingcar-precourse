package racinggame.enums;

import java.util.EnumSet;

public enum GameStatus {
    READY,
    START,
    TERMINATE;

    public boolean isSustainable() {
        return EnumSet.of(READY, START).contains(this);
    }
}
