package comp3350.bookworm.BusinessLogic;

public class InvalidEmailAddressException extends Exception {

    public InvalidEmailAddressException() {
        super("Invalid email address");
    }
}
