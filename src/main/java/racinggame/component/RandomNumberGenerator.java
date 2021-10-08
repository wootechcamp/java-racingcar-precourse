package racinggame.component;

import nextstep.utils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    public static final int MINIMUM_NUMBER = 0;
    public static final int MAXIMUM_NUMBER = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }
}
