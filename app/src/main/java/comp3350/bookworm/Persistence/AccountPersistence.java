package comp3350.bookworm.Persistence;

import java.util.List;

import comp3350.bookworm.Objects.Account;

public interface AccountPersistence {
    Account getAccountInfo(Account currentAccount);

    Account insertAccount(Account currentAccount);

    Account updateAccount(Account currentAccount);

    void deleteAccount(Account currentAccount);
}