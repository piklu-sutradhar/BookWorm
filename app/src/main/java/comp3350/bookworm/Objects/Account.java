package comp3350.bookworm.Objects;

public class Account {
    private String userName;
    private String password;
    private String email;

    public Account(String u, String p, String e) {
        userName = u;
        password = p;
        email = e;
    }


    public Account(String u, String p) {
        userName = u;
        password = p;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean equals(Account currentAccount) {
        return currentAccount.userName.equals(this.userName) && currentAccount.password.equals(this.password);
    }


}
