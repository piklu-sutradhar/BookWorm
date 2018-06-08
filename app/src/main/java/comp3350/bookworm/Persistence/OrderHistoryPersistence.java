package comp3350.bookworm.Persistence;

import java.util.ArrayList;

import comp3350.bookworm.BusinessLogic.NullAccountException;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Objects.Book;

public interface OrderHistoryPersistence {


//    ArrayList<Book> getOrderHistory(Account currentAccount) throws NullAccountException;

    ArrayList<Book> getOrderHistory(String username) throws NullAccountException;

    void addNewOrderedBooks(Account currentAccount, Book newBook);

}
