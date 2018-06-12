package comp3350.bookworm.Persistence;

import java.util.ArrayList;

import comp3350.bookworm.Objects.BookNotFoundException;
import comp3350.bookworm.Objects.InvalidAccountException;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Objects.Book;

public interface OrderHistoryPersistence {

    ArrayList<Book> getOrderHistoryCurrentUser() throws InvalidAccountException, BookNotFoundException;

    void addNewOrderedBooks(Account currentAccount, Book newBook);
}
