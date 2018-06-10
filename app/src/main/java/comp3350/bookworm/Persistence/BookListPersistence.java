package comp3350.bookworm.Persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Objects.NoBookNameFoundException;

public interface BookListPersistence {
    void insertBook(Book book) throws NoBookNameFoundException;
    Book getBook(String bookName);
    void deleteBook(String bookName);
    ArrayList<Book> getBookList();
    ArrayList<Book> getBestSellerList();
    List<Book> getSimilarBooks(String text);
}
