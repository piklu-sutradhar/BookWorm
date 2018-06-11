package comp3350.bookworm.Persistence;

import comp3350.bookworm.Objects.Account;

public interface LoginUserPersistence {

    String getUsername();

    void setUsername(String username);

    Boolean loggedIn();

    void logout();
}
