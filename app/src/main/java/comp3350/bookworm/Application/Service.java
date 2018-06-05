package comp3350.bookworm.Application;

import comp3350.bookworm.Persistence.AccountPersistence;
import comp3350.bookworm.Persistence.stubs.AccountPersistenceStub;
import comp3350.bookworm.Persistence.stubs.BookListStub;

public class Service {
    private static AccountPersistenceStub accountPersistenceStub = null;
    private static BookListStub bookListStub = null;

    public static synchronized AccountPersistenceStub getAccountPersistenceStub()
    {
        if (accountPersistenceStub == null)
        {
            accountPersistenceStub = new AccountPersistenceStub();
        }

        return accountPersistenceStub;
    }
    public static synchronized BookListStub getBookListStub()
    {
        if(bookListStub == null)
        {
            bookListStub = new BookListStub();
        }

        return bookListStub;
    }

}
