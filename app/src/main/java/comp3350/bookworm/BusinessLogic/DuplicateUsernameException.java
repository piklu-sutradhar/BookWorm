package comp3350.bookworm.BusinessLogic;

public class DuplicateUsernameException extends Exception {

    public DuplicateUsernameException() {
        super("Username already exists");
    }
}
