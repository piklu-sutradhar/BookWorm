package comp3350.bookworm.Objects;

public class InvalidCredentialException extends Exception {

    public InvalidCredentialException() {
        super("Invalid username or password");
    }
}
