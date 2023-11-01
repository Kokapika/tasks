public class SaveException extends RuntimeException {
    SaveException(String message, Exception exception) {
        super(message, exception);
    }
}
