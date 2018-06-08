package comp3350.bookworm.Objects;

public class Book {
    private final String bookName;
    private final String authorName;
    private final String bookPreview;
    private final String category;
    private final double bookPrice;

    public Book( String bookName, String authorName, String bookPreview, String category, double bookPrice ) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookPreview = bookPreview;
        this.category = category;
        this.bookPrice = bookPrice;
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

    public String getCategory() {
        return category;
    }

    public String toString() {
        return bookName + authorName + bookPreview + bookPrice;
    }

}
