package comp3350.bookworm.BusinessLogic;

public class BookNotFoundException extends Exception {

    public BookNotFoundException()
    {
        super("Book not found");
    }
}
