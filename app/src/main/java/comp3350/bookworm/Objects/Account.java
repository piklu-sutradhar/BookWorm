package comp3350.bookworm.Objects;

public class Account {
    private String userName;
    private String password;
    private String email;

//    // Default constructor
//    public Account() {
//    }

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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(Account currentAccount) {
        return currentAccount.userName.equals(this.userName) && currentAccount.password.equals(this.password);
    }
}
