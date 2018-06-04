package comp3350.bookworm.BusinessLogic;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.Objects.Account;

public class AccountManager {

    public AccountManager() {

    }

    public boolean validateAccount(Account currentAccount) {
        if(Service.getAccountPersistenceStub().getAccountInfo(currentAccount) != null)
            return true;

        return false;
    }

    public void addLoggedInUser(String username) {
        Service.getLoginUserPersistenceStub().setUsername(username);
    }

    public Boolean anyLoggedInUser() {
        return Service.getLoginUserPersistenceStub().loggedIn();
    }

    public String getLoggedInUsername() {
        return Service.getLoginUserPersistenceStub().getUsername();
    }

    public void logout() {
        Service.getLoginUserPersistenceStub().logout();
    }

}
