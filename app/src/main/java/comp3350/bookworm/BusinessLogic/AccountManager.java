package comp3350.bookworm.BusinessLogic;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Objects.DuplicateUsernameException;
import comp3350.bookworm.Objects.InvalidCredentialException;
import comp3350.bookworm.Objects.InvalidEmailAddressException;
import comp3350.bookworm.Persistence.AccountPersistence;
import comp3350.bookworm.Persistence.LoginUserPersistence;

public class AccountManager {
    private AccountPersistence accountPersistence;
    private LoginUserPersistence loginUserPersistence;


    public AccountManager() {
        accountPersistence = Service.getAccountPersistence();
        loginUserPersistence = Service.getLoginUserPersistence();
    }

    public AccountManager(final AccountPersistence accountPersistence, final LoginUserPersistence loginUserPersistence) {
        this();
        this.accountPersistence = accountPersistence;
        this.loginUserPersistence = loginUserPersistence;
    }

    public void login (Account currentAccount) throws InvalidCredentialException {
        Account account = accountPersistence.getAccountInfo(currentAccount);
        if(account == null)
            throw new InvalidCredentialException();
        loginUserPersistence.setUsername(account.getUserName());
    }

    public void singup(Account currentAccount) throws DuplicateUsernameException, InvalidEmailAddressException {
        try {
            String email = currentAccount.getEmail();
            if(!isValidEmailAddress(email))
                throw new InvalidEmailAddressException();

            accountPersistence.insertAccount(currentAccount);
        }
        catch (DuplicateUsernameException e) {
            throw new DuplicateUsernameException();
        }
    }

    public Boolean anyLoggedInUser() {
        return loginUserPersistence.loggedIn();
    }

    public String getLoggedInUsername() {
        return loginUserPersistence.getUsername();
    }

    public void logout() {
        loginUserPersistence.logout();
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

}
