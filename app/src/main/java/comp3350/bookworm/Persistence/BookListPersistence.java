package comp3350.bookworm.Persistence;

import comp3350.bookworm.Objects.Book;

public interface BookListPersistence {
    void insertBook(Book book);
    Book searchBook(String bookName);
}
