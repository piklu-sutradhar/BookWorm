package comp3350.bookworm.Persistence.stubs;

import java.util.ArrayList;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.Objects.InvalidAccountException;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Persistence.OrderHistoryPersistence;


public class OrderHistoryPersistenceStub implements OrderHistoryPersistence {
    private ArrayList<Account> accounts;
    private ArrayList<ArrayList<Book>> accountOfBooks;

    public OrderHistoryPersistenceStub() {
        accounts = Service.getAccountPersistenceStub().getAllAccounts();
        accountOfBooks = new ArrayList<>();
        ArrayList<Book> bookList = new ArrayList<>();

        bookList.add(new Book("C++", "Daniel J. Fung", "Programming book", 5.0));
        bookList.add(new Book("Java", "Daniel J. Fung", "Programming book", 5.0));

        for(int i = 0; i < accounts.size(); i++ )
        {
            accountOfBooks.add(bookList);
        }
    }

//    @Override
//    public ArrayList<Book> getOrderHistory(String username) throws InvalidAccountException {
//        ArrayList<Book> booksOfAccount = null;
//        for(int i = 0 ; i < accounts.size(); i++)
//        {
//            if(accounts.get(i) == null)
//                throw new InvalidAccountException();
//
//            if(accounts.get(i).getUserName().equals(username))
//            {
//                booksOfAccount = accountOfBooks.get(i);
//            }
//
//        }
//        return booksOfAccount;
//    }

    @Override
    public ArrayList<Book> getOrderHistoryCurrentUser() throws InvalidAccountException {
        ArrayList<Book> booksOfAccount = null;

        if(!Service.getLoginUserPersistenceStub().loggedIn()) {
            throw new InvalidAccountException();
        }

        for(int i = 0 ; i < accounts.size(); i++)
        {
            if(accounts.get(i).getUserName().equals(Service.getLoginUserPersistenceStub().getUsername()))
            {
                booksOfAccount = accountOfBooks.get(i);
            }

        }
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
