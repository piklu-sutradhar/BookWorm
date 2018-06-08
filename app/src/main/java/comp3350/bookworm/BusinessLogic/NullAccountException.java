package comp3350.bookworm.BusinessLogic;

public class NullAccountException extends Exception {
    public NullAccountException() {
        super("Null account");
    }
}
