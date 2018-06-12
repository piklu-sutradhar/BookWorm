package comp3350.bookworm.Objects;

public class DuplicateBookException extends Exception {
    public DuplicateBookException() {
        super("Duplicate Book found");
    }
}
