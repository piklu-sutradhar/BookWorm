package comp3350.bookworm.Objects;

public class Book {
    private final String bookName;
    private final String authorName;
    private final String bookPreview;
    private final double bookPrice;
    private double bookRating;

    public Book( String bookName, String authorName, String bookPreview, double bookPrice ) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookPreview = bookPreview;
        this.bookPrice = bookPrice;
    }

    //@@ overloading
    public Book( String bookName, String authorName, String bookPreview, double bookPrice, double bookRating ) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookPreview = bookPreview;
        this.bookPrice = bookPrice;
        this.bookRating = bookRating;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() { return authorName; }

    public String getPreview() {
        return bookPreview;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookRatin( double rating ) { bookRating = rating; }

    public double getBookRating() { return bookRating; }

    public String toString() {
        return bookName + authorName + bookPreview + bookPrice;
    }

}
