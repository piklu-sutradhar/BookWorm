package comp3350.bookworm.Application;

import comp3350.bookworm.Persistence.AccountPersistence;
import comp3350.bookworm.Persistence.BookListPersistence;
import comp3350.bookworm.Persistence.LoginUserPersistence;
import comp3350.bookworm.Persistence.OrderHistoryPersistence;
<<<<<<< HEAD
=======
import comp3350.bookworm.Persistence.hsqldb.AccountPersistenceHSQLDB;
>>>>>>> 2b17445c3714948d4abe2bc41d5fd6aeb12378b9
import comp3350.bookworm.Persistence.stubs.AccountPersistenceStub;
import comp3350.bookworm.Persistence.stubs.BookListPersistenceStub;
import comp3350.bookworm.Persistence.stubs.LoginUserPersistenceStub;
import comp3350.bookworm.Persistence.stubs.OrderHistoryPersistenceStub;

public class Service {
    private static AccountPersistence accountPersistence = null;
    private static BookListPersistence bookListPersistence = null;
    private static LoginUserPersistence loginUserPersistence = null;
    private static OrderHistoryPersistence orderHistory = null;


    public static synchronized AccountPersistence getAccountPersistence()
    {
        if (accountPersistence == null) {
<<<<<<< HEAD
            accountPersistence = new AccountPersistenceStub();
=======
//            accountPersistence = new AccountPersistenceStub();
            accountPersistence = new AccountPersistenceHSQLDB(Main.getDBPathName());

>>>>>>> 2b17445c3714948d4abe2bc41d5fd6aeb12378b9
        }
        return accountPersistence;
    }

    public static synchronized BookListPersistence getBookListPersistence()
    {
        if(bookListPersistence == null) {
            bookListPersistence = new BookListPersistenceStub();
        }
        return bookListPersistence;
    }

    public static synchronized OrderHistoryPersistence getOrderHistoryPersistence()
    {
        if(orderHistory == null)
        {
            orderHistory = new OrderHistoryPersistenceStub();
        }
        return orderHistory;
    }

    public static synchronized LoginUserPersistence getLoginUserPersistence() {
        if(loginUserPersistence == null) {
            loginUserPersistence = new LoginUserPersistenceStub();
        }
        return loginUserPersistence;
    }

}
