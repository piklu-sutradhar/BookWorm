package comp3350.bookworm.Objects;

public class Book {
    // Hold the info of each book

    private final String bookName;
    private final String authorName;
    private final String bookPreview;
    private final double bookPrice;

    public Book( String bookName, String authorName, String bookPreview, double bookPrice ) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookPreview = bookPreview;
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPreview() {
        return bookPreview;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public String toStirng() {
        return bookName + authorName + bookPreview + bookPrice;
    }

}
