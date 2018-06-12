package comp3350.bookworm.Persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Objects.BookNotFoundException;
import comp3350.bookworm.Objects.DuplicateBookException;
import comp3350.bookworm.Objects.InvalidBookException;

public interface BookListPersistence {
    void insertBook(Book book) throws DuplicateBookException, InvalidBookException;
    Book getBook(String bookName) throws BookNotFoundException;
    void deleteBook(String bookName) throws BookNotFoundException;
    ArrayList<Book> getBookList();
    List<Book> getSimilarBooks(String text);
    void setBookList(ArrayList<Book> bookList);
}
