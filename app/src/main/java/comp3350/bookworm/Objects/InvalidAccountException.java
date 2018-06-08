package comp3350.bookworm.Objects;

public class InvalidAccountException extends Exception {
    public InvalidAccountException() {
        super("Null account");
    }
}
