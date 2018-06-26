package comp3350.bookworm.Persistence.stubs;

import java.util.ArrayList;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.Objects.BookNotFoundException;
import comp3350.bookworm.Objects.InvalidAccountException;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Persistence.OrderHistoryPersistence;


public class OrderHistoryPersistenceStub implements OrderHistoryPersistence {
    private ArrayList<Account> accounts;
    private ArrayList<ArrayList<Book>> accountOfBooks;

    public OrderHistoryPersistenceStub() {
        accounts = Service.getAccountPersistence().getAllAccounts();
        accountOfBooks = new ArrayList<>();
        ArrayList<Book> bookList = new ArrayList<>();

        bookList.add(new Book("Steamy Romance 5: The Reckoning", "Daniel J. Fung", "Romance book", "Romance", 10.0, 5.0, 8));
        bookList.add(new Book("How to Fix an ID10T error Vol 2", "Daniel J. Fung", "Programming book", "Programming", 10.0, 5.0, 9));
        bookList.add(new Book("How to Fix an ID10T error Vol 1", "Daniel J. Fung", "Programming book", "Programming", 10.0, 5.0, 10));
        bookList.add(new Book("Harry Potter and the Evil Potato", "Daniel J. Fung", "Fantasy book", "Fantasy", 10.0, 5.0, 11));
        bookList.add(new Book("C++", "Daniel J. Fung", "Programming book", "Programming", 10.0, 5.0, 1));
        bookList.add(new Book("Java", "Daniel J. Fung", "Programming book", "Programming", 10.0, 5.0, 2));
        bookList.add(new Book("C#", "Daniel J. Fung", "Programming book", "Programming", 10.0, 5.0, 3));
        bookList.add(new Book("C++ : The Return of the C++ King", "Daniel J. Fung", "Programming book", "Programming", 10.0, 5.0, 4));

        for(int i = 0; i < accounts.size(); i++ )
        {
            accountOfBooks.add(bookList);
        }
    }

    @Override
    public ArrayList<Book> getOrderHistoryCurrentUser() throws InvalidAccountException, BookNotFoundException {
        ArrayList<Book> booksOfAccount = null;

        if(!Service.getLoginUserPersistence().loggedIn()) {
            throw new InvalidAccountException();
        }

        for(int i = 0 ; i < accountOfBooks.size(); i++)
        {
            if(accounts.get(i).getUserName().equals(Service.getLoginUserPersistence().getUsername()))
            {
                booksOfAccount = accountOfBooks.get(i);
            }

        }

        if(booksOfAccount == null)
            throw new BookNotFoundException();
        return booksOfAccount;
    }

    @Override
    public void addNewOrderedBooks(Account currentAccount, Book newBook)
    {
        for(int i = 0 ; i < accounts.size(); i++)
        {
            if(accounts.get(i) != null)
            {
                if(accounts.get(i).getUserName().equals(currentAccount.getUserName()))
                {
                    accountOfBooks.get(i).add(newBook);
                }
            }
        }
    }
}
