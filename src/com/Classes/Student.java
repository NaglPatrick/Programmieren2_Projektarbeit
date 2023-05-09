package com.Classes;
/*
 * ISchedule
 * Program to let Professors(com.Classes.Admin), assistants and student schedule their preferred courses
 * Author: Nagl Patrick
 * Last Change:  05.05.2022
 */

public class Student {

    private String userName;
    private String password;
    private String eMail;

    //Constructor
    public Student(String userName, String password, String eMail) {
        this.userName = userName;
        this.password = password;
        this.eMail = eMail;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

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
