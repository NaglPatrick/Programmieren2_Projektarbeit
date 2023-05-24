package com.Classes;

public class User {
    private String userName;
    private String password;
    private String eMail;
    private String role;

    //Constructor
    public User(String userName, String eMail, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.eMail = eMail;
        this.role = role;
    }

    //Setter
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }


    //Getter

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String geteMail() {
        return eMail;
    }

    public String getRole() {
        return role;
    }
}
