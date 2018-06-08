package comp3350.bookworm.Persistence;

import java.util.List;

import comp3350.bookworm.Objects.Book;

public interface BookListPersistence {
    void insertBook(Book book);
    Book searchBook(String bookName);
    void deleteBook(String bookName);
    List<Book> getSimilarBooks(String text);
}
