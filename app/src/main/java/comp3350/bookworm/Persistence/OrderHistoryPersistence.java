package comp3350.bookworm.Persistence;

import java.util.ArrayList;

import comp3350.bookworm.Objects.InvalidAccountException;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Objects.Book;

public interface OrderHistoryPersistence {


//    ArrayList<Book> getOrderHistory(Account currentAccount) throws InvalidAccountException;

//    ArrayList<Book> getOrderHistory(String username) throws InvalidAccountException;

    ArrayList<Book> getOrderHistoryCurrentUser() throws InvalidAccountException;

    void addNewOrderedBooks(Account currentAccount, Book newBook);
}
