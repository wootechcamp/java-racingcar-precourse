package racinggame.view;

public final class OutputView {

    private OutputView() {
    }

    public static void printMessage(final String message) {
        System.out.println(message);
    }

    public static void lineSeparator() {
        System.out.println();
    }

    public static void printError(final Throwable cause) {
        System.out.println(cause.getMessage());
    }
}
