package comp3350.bookworm.Persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.bookworm.Objects.Book;

public interface BookListPersistence {
    void insertBook(Book book);
    Book getBook(String bookName);
    void deleteBook(String bookName);
    ArrayList<Book> getBookList();
    ArrayList<Book> getBestSellerList();
    List<Book> getSimilarBooks(String text);
}
