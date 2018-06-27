package comp3350.bookworm.Persistence.hsqldb;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Objects.DuplicateUsernameException;
import comp3350.bookworm.Persistence.AccountPersistence;

public class AccountPersistenceHSQLDB implements AccountPersistence {
    private final Connection c;

    public AccountPersistenceHSQLDB(final String dbPath) {
        try {
            this.c = DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath, "SA", "");
        } catch (final SQLException e) {
            Log.e("Connect SQL", e.getMessage() + e.getSQLState());
            throw new PersistenceException(e);
        }
    }

    private Account fromResultSet(final ResultSet rs) throws SQLException {
        final String username = rs.getString("username");
        final String password = rs.getString("password");
        final String email = rs.getString("email");
        return new Account(username, password, email);
    }

    @Override
    public Account getAccountInfo(Account currentAccount) {
        Account account = null;

        try {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM Accounts WHERE username = ? AND password = ?");
            st.setString(1, currentAccount.getUserName());
            st.setString(2, currentAccount.getPassword());
            final ResultSet rs = st.executeQuery();
            if(rs.first())
                account = fromResultSet(rs);
            rs.close();
            st.close();

            return account;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Account insertAccount(Account currentAccount) throws DuplicateUsernameException {
        try {
            PreparedStatement st = c.prepareStatement("INSERT INTO Accounts VALUES(?, ?, ?)");
            st.setString(1, currentAccount.getUserName());
            st.setString(2, currentAccount.getPassword());
            st.setString(3, currentAccount.getEmail());

            st.executeUpdate();

            return currentAccount;
        } catch (final SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException)
                throw new DuplicateUsernameException();
            else
                throw new PersistenceException(e);
        }
    }

    @Override
    public Account updateAccount(Account currentAccount) {
        try {
            PreparedStatement st = c.prepareStatement("UPDATE Accounts " +
                    "SET username = ? AND password = ? AND email = ? WHERE username = ?");
            st.setString(1, currentAccount.getUserName());
            st.setString(2, currentAccount.getPassword());
            st.setString(3, currentAccount.getEmail());

            st.executeUpdate();

            return currentAccount;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void deleteAccount(Account currentAccount) {
        try {
            final PreparedStatement st = c.prepareStatement("DELETE FROM Accounts WHERE username = ?");
            st.setString(1, currentAccount.getUserName());
            st.executeUpdate();
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        final List<Account> accounts = new ArrayList<>();

        try
        {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM Accounts");
            while (rs.next())
            {
                final Account course = fromResultSet(rs);
                accounts.add(course);
            }
            rs.close();
            st.close();

            return accounts;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }
}
