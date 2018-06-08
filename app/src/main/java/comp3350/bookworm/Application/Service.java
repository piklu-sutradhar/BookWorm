package comp3350.bookworm.Application;

import comp3350.bookworm.Persistence.stubs.AccountPersistenceStub;
import comp3350.bookworm.Persistence.stubs.BookListStub;
import comp3350.bookworm.Persistence.stubs.LoginUserPersistenceStub;
import comp3350.bookworm.Persistence.stubs.BookListStub;
import comp3350.bookworm.Persistence.stubs.LoginUserPersistenceStub;

public class Service {
    private static AccountPersistenceStub accountPersistenceStub = null;
    private static BookListStub bookListStub = null;

    private static LoginUserPersistenceStub loginUserPersistenceStub = null;

    public static synchronized AccountPersistenceStub getAccountPersistenceStub()
    {
        if (accountPersistenceStub == null) {
            accountPersistenceStub = new AccountPersistenceStub();
        }

        return accountPersistenceStub;
    }
    public static synchronized BookListStub getBookListStub()
    {
        if(bookListStub == null) {
            bookListStub = new BookListStub();
        }

        return bookListStub;
    }

    public static synchronized LoginUserPersistenceStub getLoginUserPersistenceStub() {
        if(loginUserPersistenceStub == null) {
            loginUserPersistenceStub = new LoginUserPersistenceStub();
        }

        return loginUserPersistenceStub;
    }
}
