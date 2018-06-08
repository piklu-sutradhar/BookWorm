package comp3350.bookworm.Persistence.stubs;

import java.util.ArrayList;

import comp3350.bookworm.Objects.DuplicateUsernameException;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Persistence.AccountPersistence;

public class AccountPersistenceStub implements AccountPersistence {
    private ArrayList<Account> accounts;


    public AccountPersistenceStub() {
        this.accounts = new ArrayList<>();

        accounts.add(new Account("admin", "admin","admin@bookworm.ca"));
        accounts.add(new Account("visitor", "visitor","visitor@bookworm.ca"));
        accounts.add(new Account("mingo", "mingo","mingo@bookworm.ca"));
        accounts.add(new Account("piklu", "piklu","piklu@bookworm.ca"));
        accounts.add(new Account("q", "q","q@bookworm.ca"));
        accounts.add(new Account("cj", "cj","cj@bookworm.ca"));
        accounts.add(new Account("harrison", "harrison","harrison@bookworm.ca"));
        accounts.add(new Account("jeff", "jeff","jeff@bookworm.ca"));
    }

    @Override
    public Account getAccountInfo(Account currentAccount) {
        for(Account account : accounts) {
            if(account.equals(currentAccount)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public Account insertAccount(Account currentAccount) throws DuplicateUsernameException {

        for(Account account : accounts) {
            if (account.getUserName().equals(currentAccount.getUserName()))
                throw new DuplicateUsernameException();
        }
        accounts.add(currentAccount);
        return currentAccount;
    }

    @Override
    public Account updateAccount(Account currentAccount) {
        int index;

        index = accounts.indexOf(currentAccount);
        if (index >= 0)
        {
            accounts.set(index, currentAccount);
        }
        return currentAccount;
    }

    @Override
    public void deleteAccount(Account currentAccount) {
        int index;

        index = accounts.indexOf(currentAccount);
        if (index >= 0)
        {
            accounts.remove(index);
        }
    }

    @Override
    public ArrayList<Account> getAllAccounts() {
        return accounts;
    }
}


