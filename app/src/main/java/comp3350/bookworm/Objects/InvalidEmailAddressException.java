package comp3350.bookworm.Objects;

public class InvalidEmailAddressException extends Exception {

    public InvalidEmailAddressException() {
        super("Invalid email address");
    }
}
