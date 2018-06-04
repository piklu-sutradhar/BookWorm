package comp3350.bookworm.Application;

import comp3350.bookworm.Persistence.AccountPersistence;
import comp3350.bookworm.Persistence.stubs.AccountPersistenceStub;
import comp3350.bookworm.Persistence.stubs.LoginUserPersistenceStub;

public class Service {
    private static AccountPersistenceStub accountPersistenceStub = null;

    private static LoginUserPersistenceStub loginUserPersistenceStub = null;

    public static synchronized AccountPersistenceStub getAccountPersistenceStub()
    {
        if (accountPersistenceStub == null) {
            accountPersistenceStub = new AccountPersistenceStub();
        }

        return accountPersistenceStub;
    }

    public static synchronized LoginUserPersistenceStub getLoginUserPersistenceStub() {
        if(loginUserPersistenceStub == null) {
            loginUserPersistenceStub = new LoginUserPersistenceStub();
        }

        return loginUserPersistenceStub;
    }
//
//    public static synchronized LoginUserPersistenceStub addLoggedInUser(String username) {
//        if(loginUserPersistenceStub == null) {
//            loginUserPersistenceStub = new LoginUserPersistenceStub(username);
//        }
//        else {
//            loginUserPersistenceStub.setUsername(username);
//        }
//
//        return loginUserPersistenceStub;
//    }
//
//    public static synchronized Boolean anyLoggedInUser() {
//        if(loginUserPersistenceStub == null)
//            return false;
//        else
//            return loginUserPersistenceStub.loggedIn();
//    }
//
//    public static synchronized String getLoggedInUsername() {
//        if(loginUserPersistenceStub != null)
//            return loginUserPersistenceStub.getUsername();
//        return null;
//    }
//
//    public static synchronized void logout() {



}
