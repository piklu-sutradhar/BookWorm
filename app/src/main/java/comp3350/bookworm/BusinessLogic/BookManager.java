package comp3350.bookworm.BusinessLogic;

import java.util.ArrayList;
import java.util.Collections;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Objects.BookNotFoundException;
import comp3350.bookworm.Objects.DuplicateBookException;
import comp3350.bookworm.Objects.InvalidAccountException;
import comp3350.bookworm.Objects.InvalidBookException;
import comp3350.bookworm.Persistence.BookListPersistence;
import comp3350.bookworm.Persistence.OrderHistoryPersistence;
import comp3350.bookworm.Persistence.stubs.BookListPersistenceStub;

public class BookManager {
    private BookListPersistence bookListPersistence;
    private OrderHistoryPersistence orderHistoryPersistence;

    public BookManager() {
        bookListPersistence = Service.getBookListPersistence();
        orderHistoryPersistence = Service.getOrderHistoryPersistence();
    }

    public void addBook(Book bookToadd) throws DuplicateBookException, InvalidBookException {
        bookListPersistence.insertBook(bookToadd);
    }

    public Book searchBook(String bookName) throws BookNotFoundException {
        return bookListPersistence.getBook(bookName);
    }

    public void deleteBook(String bookName) throws BookNotFoundException {
        bookListPersistence.deleteBook(bookName);
    }

    public ArrayList<Book> getBookList() {
        return bookListPersistence.getBookList();
    }

    public static ArrayList<Book> getBestSellerList(ArrayList<Book> baseList) {
        Collections.sort(baseList);

        return baseList;
    }

    public ArrayList<Book> getOrderHistoryForCurrentUser() throws InvalidAccountException, BookNotFoundException {
        return orderHistoryPersistence.getOrderHistoryCurrentUser();
    }
}
