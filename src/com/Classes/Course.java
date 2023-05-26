package com.Classes;

import java.sql.Time;
import java.util.*;

public class Course {

    private String courseName;
    private Time timeStart;
    private Time timeEnd;
    private String weekday;
    private  Room room;
    private User user;
//    private List<Course> courseList;


    //constructors
    public Course(String courseName) {
        this.courseName = courseName;
    }
    public Course(String courseName, Room room, Time timeStart, Time timeEnd, String weekday, User user) {
        this.courseName = courseName;
        this.room = room;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.weekday = weekday;
        this.user = user;
//        this.courseList = new ArrayList<Course>();
        room.setEmpty();
        room.addCourseList(this);
        user.addCourseList(this);
//        this.addCourseList(this);


    }



    //setter
    public void setCourseName(String courseName) {
        courseName = courseName;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setWeekday(String day) {
        this.weekday = day;
    }

//    public void addCourseList(Course course) {
//        courseList.put(course.getCourseName(), course);
//    }

    //getter
    public String getCourseName() {
        return courseName;
    }

    public Time getTimeStart() {
        return timeStart;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public String getWeekday() {
        return weekday;
    }

    public User getUser() {
        return user;
    }

//    public Map<String, Course> getCourseList() {
//        return courseList;
//    }
}
