package comp3350.bookworm.Application;

import comp3350.bookworm.Persistence.stubs.AccountPersistenceStub;
<<<<<<< HEAD
//<<<<<<< HEAD
import comp3350.bookworm.Persistence.stubs.BookListStub;
//=======
import comp3350.bookworm.Persistence.stubs.LoginUserPersistenceStub;
//>>>>>>> 35da3234a63396c3ef890150ad84f2d89fc1cbba
=======
import comp3350.bookworm.Persistence.stubs.BookListStub;
import comp3350.bookworm.Persistence.stubs.LoginUserPersistenceStub;
>>>>>>> cafea6f8a9642e83a419431534e445cf0b3b7ba4

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
