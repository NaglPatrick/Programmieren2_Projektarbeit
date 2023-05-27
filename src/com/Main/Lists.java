package com.Main;

/*
 * ISchedule
 * Program to let Professors(com.Classes.Admin), assistants and student schedule their preferred courses
 * Author: Nagl Patrick
 * Last Change:  27.05.2022
 */

import com.Classes.*;


import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lists {

    private static Map<String, User> userList;

    private static Map<String, Room> roomList;
    private static List<Course> courseList;
    private static List<Course> courseListBox;

    public Lists() {
        this.userList = new HashMap<String, User>();
        this.roomList = new HashMap<String, Room>();
        this.courseList = new ArrayList<Course>();
        this.courseListBox = new ArrayList<Course>();
        initialize();
    }

    //add to methods/setter
    public static void addUserList(User user) {
        userList.put(user.getUserName(), user);
    }



    public static void addRoomList(Room room) {
        roomList.put(room.getRoomName(), room);
    }
    public static void addCourseList(Course course) {
        courseList.add(course);
        addCourseListBox(course);
    }
    public static void addCourseListBox(Course course) {
        if (courseListBox.isEmpty()) {
            courseListBox.add(course);
        }
        boolean compare = true;
        for (Course c : courseListBox) {
            if (c.getCourseName().equals(course.getCourseName())) {
                compare = false;
            }
        }
        if (compare) {
            courseListBox.add(course);
        }
    }
    //getter

    public static Map<String, User> getUserList() {
        return userList;
    }



    public static Map<String, Room> getRoomList() {
        return roomList;
    }

    public static List<Course> getCourseList() {
        return courseList;
    }

    public static List<Course> getCourseListBox() {
        return courseListBox;
    }

    //custom methods for List
    public static List<Course> getCoursesByName(String name) {
        List<Course> result = new ArrayList<Course>();
        for (Course c : courseList) {
            if (c.getCourseName() == name) {
                result.add(c);
            }
        }
        return result;
    }

    public static boolean isCourseAvailable(Course course) {
        boolean result = false;
            if (course.getUser() != null) {
                result = true;
        }
            return result;
    }

    //delete methods
    public static void removeRoomFromList (Room room) {
        roomList.remove(room.getRoomName(), room);
    }
    public static void removeCourseFromList (String name) {
        for (int i = courseList.size() -1; i >= 0 ; i--) {
            if (courseList.get(i).getCourseName().equals(name)) {
                courseList.remove(i);
            }
        }
        for (int i = 0; i < courseListBox.size(); i++) {
            if (courseListBox.get(i).getCourseName().equals(name)) {
                courseListBox.remove(i);
            }
        }

    }
    public static void removeSpecificCourseFromList (String name, String time) {
        for (int i = courseList.size() -1; i >= 0 ; i--) {
            if (courseList.get(i).getCourseName().equals(name) && courseList.get(i).getTimeStart().toString().equals(time)) {
                courseList.remove(i);
            }
        }
    }

    //initialize some basic inputs for lists
    private void initialize() {
        //admins
        User admin1 = new User("Master", "master@gmx.at", "4321", "Admin");
        addUserList(admin1);

        //Assis
        User assi1 = new User("Dominik", "dom@gmx.at", "1234", "Assistant");
        User assi2 = new User("Matze", "mathias@gmail.com", "password", "Assistant");
        addUserList(assi1);
        addUserList(assi2);

        //Students
        User stud1 = new User("Vilja", "vilja@web.de", "password", "Student");
        addUserList(stud1);

        //rooms
        Room room1 = new Room("Room 101");
        Room room2 = new Room("Room 102");
        Room room3 = new Room("Room 103");
        Room room4 = new Room("Room 202");
        Room room5 = new Room("Room 204");
        addRoomList(room1);
        addRoomList(room2);
        addRoomList(room3);
        addRoomList(room4);
        addRoomList(room5);

        //courses
        Course course1 = new Course("Mathe", room1, Time.valueOf(Application.correctTime("8:00")), Time.valueOf(Application.correctTime("11:30")), "Monday", admin1);
        Course course2 = new Course("Mathe", room1, Time.valueOf(Application.correctTime("8:00")), Time.valueOf(Application.correctTime("11:30")), "Tuesday", admin1);
        Course course3 = new Course("English", room2, Time.valueOf(Application.correctTime("12:00")), Time.valueOf(Application.correctTime("13:30")), "Monday", assi1);
        Course course4 = new Course("English", room2, Time.valueOf(Application.correctTime("12:00")), Time.valueOf(Application.correctTime("13:30")), "Tuesday", assi2);
        addCourseList(course1);
        addCourseList(course2);
        addCourseList(course3);
        addCourseList(course4);
        admin1.addCourseAttendingList(course1);
        admin1.addCourseAttendingList(course2);
        assi1.addCourseAttendingList(course3);
        assi2.addCourseAttendingList(course4);


    }


}
