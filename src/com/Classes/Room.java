package com.Classes;

/*
 * ISchedule
 * Program to let Professors(com.Classes.Admin), assistants and student schedule their preferred courses
 * Author: Nagl Patrick
 * Last Change:  05.05.2022
 */

import java.util.HashMap;
import java.util.Map;

import com.Main.Lists;

public class Room {

    private String roomName;
    private boolean empty;
    private Map<String, Course> courseList;

    //constructor
    public Room(String roomName) {
        this.roomName = roomName;
        this.courseList = new HashMap<String, Course>();
        this.empty = true;
    }

//    public Room(String roomName, boolean hasCourse) {
//        this.courseList = Lists.getCourseList();
//    }

    //setter
    public void setEmpty() {
        this.empty = false;
    }

    public void addCourseList(Course course) {
        courseList.put(course.getCourseName(), course);
    }

    //getter
    public String getRoomName() {
        return roomName;
    }

    public boolean isEmpty() {
        return empty;
    }

    public Map<String, Course> getCourseList() {
        return courseList;
    }
}
