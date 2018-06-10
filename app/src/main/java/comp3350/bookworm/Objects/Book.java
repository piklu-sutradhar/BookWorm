package comp3350.bookworm.Objects;

public class Book implements Comparable {
    private final String bookName;
    private final String authorName;
    private final String bookPreview;
    private String category;
    private final double bookPrice;
    private double bookRating;
    private int bookSoldNum;

    public Book( String bookName, String authorName, String bookPreview, String category, double bookPrice ) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookPreview = bookPreview;
        this.category = category;
        this.bookPrice = bookPrice;
        this.bookSoldNum = 0;
    }

    public Book( String bookName, String authorName, String bookPreview, double bookPrice, double bookRating, int numSold) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookPreview = bookPreview;
        this.bookPrice = bookPrice;
        this.bookSoldNum = numSold;
        this.bookRating = bookRating;
    }

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

    public int getBookSoldNum(){ return bookSoldNum;}

    public double getBookPrice() {
        return bookPrice;
    }

<<<<<<< HEAD
    public void setBookRating( double rating ) { bookRating = rating; }
=======
    public String getCategory() {
        return category;
    }

    public void setBookRatin( double rating ) { bookRating = rating; }
>>>>>>> 796ba1d5e3bcba6ad59bad7b8161d18b4aad3f5b

    public double getBookRating() { return bookRating; }
    public String toString() {
        return bookName + authorName + bookPreview + bookPrice;
    }

    public void incBookSold(int numSold){bookSoldNum += numSold;}

    @Override
    public int compareTo(Object compareNumSold) {
        int compareCopiesSold=((Book)compareNumSold).getBookSoldNum();
        return compareCopiesSold - this.bookSoldNum;
    }

}
