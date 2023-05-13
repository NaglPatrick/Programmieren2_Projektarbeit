package com.Classes;
/*
 * ISchedule
 * Program to let Professors(com.Classes.Admin), assistants and student schedule their preferred courses
 * Author: Nagl Patrick
 * Last Change:  05.05.2022
 */

public class Assistant {

    private String userName;
    private String password;
    private String eMail;

    //Constructor

    public Assistant(String userName, String eMail, String password) {
        this.userName = userName;
        this.password = password;
        this.eMail = eMail;
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
}
