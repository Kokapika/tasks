public class SaveException extends RuntimeException {
    public SaveException(String str, Exception exception) {
        super(str, exception);
    }
}
