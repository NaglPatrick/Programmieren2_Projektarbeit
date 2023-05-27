package com.Classes;

/*
 * ISchedule
 * Program to let Professors(com.Classes.Admin), assistants and student schedule their preferred courses
 * Author: Nagl Patrick
 * Last Change:  27.05.2022
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String userName;
    private String password;
    private String eMail;
    private String role;
    private Map<String, Course> courseList;
    private List<Course> courseAttendingList;

    //Constructor
    public User(String userName, String eMail, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.eMail = eMail;
        this.role = role;
        this.courseList = new HashMap<String, Course>();
        this.courseAttendingList = new ArrayList<Course>();
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

    public void addCourseList(Course course) {
        courseList.put(course.getCourseName(), course);
    }
    public void addCourseAttendingList(Course course) {
        courseAttendingList.add(course);
    }
    public void removeCourseAttendingList(Course course) {
        courseAttendingList.remove(course);
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
    public Map<String, Course> getCourseList() {
        return courseList;
    }

    public List<Course> getCourseAttendingList() {
        return courseAttendingList;
    }
}
