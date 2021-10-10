package racinggame.view;

public final class OutputView {

    private OutputView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printError(Throwable e) {
        System.out.println(e.getMessage());
    }
}
