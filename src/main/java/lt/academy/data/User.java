package lt.academy.data;

public class User {
    String userId;
    String userLogin;
    String password;
    String name;
    String surname;

    User(){}

    public User(String userId, String userLogin, String password, String name, String surname) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
