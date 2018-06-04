package comp3350.bookworm.Application;

import comp3350.bookworm.Persistence.AccountPersistence;
import comp3350.bookworm.Persistence.stubs.AccountPersistenceStub;

public class Service {
    private static AccountPersistenceStub accountPersistenceStub = null;

    public static synchronized AccountPersistenceStub getAccountPersistenceStub()
    {
        if (accountPersistenceStub == null)
        {
            accountPersistenceStub = new AccountPersistenceStub();
        }

        return accountPersistenceStub;
    }

}
