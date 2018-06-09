package comp3350.bookworm.BusinessLogic;

import android.text.TextUtils;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Objects.DuplicateUsernameException;
import comp3350.bookworm.Objects.InvalidCredentialException;
import comp3350.bookworm.Objects.InvalidEmailAddressException;

public class AccountManager {

    public AccountManager() {

    }

    public void login (Account currentAccount) throws InvalidCredentialException {
        Account account = Service.getAccountPersistenceStub().getAccountInfo(currentAccount);
        if(account == null)
            throw new InvalidCredentialException();
        addLoggedInUser(account.getUserName());
    }

    public void singup(Account currentAccount) throws DuplicateUsernameException, InvalidEmailAddressException {
        try {
            String email = currentAccount.getEmail();
            if(TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
                throw new InvalidEmailAddressException();

            Service.getAccountPersistenceStub().insertAccount(currentAccount);
        }
        catch (DuplicateUsernameException e) {
            throw new DuplicateUsernameException();
        }
    }

    private void addLoggedInUser(String username) {
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
