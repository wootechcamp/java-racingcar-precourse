package racinggame;

import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApplicationTest extends NSTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    void 중복우승자() {
        assertRandomTest(() -> {
            run("pobi,woni", "2");
            verify("pobi : --", "woni : --", "최종 우승자는 pobi,woni 입니다.");
        }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 전진_정지() {
        assertRandomTest(() -> {
            run("pobi,woni", "1");
            verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,javaji");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 시도회수를_음수로_넣었을때_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,woni,wook", "-1");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 시도회수를_숫자가_아닌_값으로_넣었을때_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,woni,wook", "숫자");
            verify(ERROR_MESSAGE);
        });
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
