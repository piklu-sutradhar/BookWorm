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
        Service.getLoginUserPersistenceStub().setUsername(account.getUserName());
    }

    public void singup(Account currentAccount) throws DuplicateUsernameException, InvalidEmailAddressException {
        try {
            String email = currentAccount.getEmail();
            if(!isValidEmailAddress(email))
                throw new InvalidEmailAddressException();

            Service.getAccountPersistenceStub().insertAccount(currentAccount);
        }
        catch (DuplicateUsernameException e) {
            throw new DuplicateUsernameException();
        }
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

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

}
