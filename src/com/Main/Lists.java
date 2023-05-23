package com.Main;

import com.Classes.Admin;
import com.Classes.Assistant;
import com.Classes.Student;
import com.Classes.Room;
import com.Classes.Course;


import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class Lists {

    private static Map<String, Admin> adminList;
    private static Map<String, Assistant> assiList;
    private static Map<String, Student> studList;
    private static Map<String, Room> roomList;
    private static Map<String, Course> courseList;

    public Lists() {
        this.adminList = new HashMap<String, Admin>();
        this.assiList = new HashMap<String, Assistant>();
        this.studList = new HashMap<String, Student>();
        this.roomList = new HashMap<String, Room>();
        this.courseList = new HashMap<String, Course>();
        initialize();
    }

    //add to methods/setter
    public static void addAdminList(Admin admin) {
        adminList.put(admin.getUserName(), admin);
    }

    public static void addAssiList(Assistant assi) {
        assiList.put(assi.getUserName(), assi);
    }

    public static void addStudList(Student stud) {
        studList.put(stud.getUserName(), stud);
    }

    public static void addRoomList(Room room) {
        roomList.put(room.getRoomName(), room);
    }
    public static void addCourseList(Course course) {
        courseList.put(course.getCourseName(), course);
    }

    //getter
    public static Map<String, Admin> getAdminList() {
        return adminList;
    }

    public static Map<String, Assistant> getAssiList() {
        return assiList;
    }

    public static Map<String, Student> getStudList() {
        return studList;
    }

    public static Map<String, Room> getRoomList() {
        return roomList;
    }

    public static Map<String, Course> getCourseList() {
        return courseList;
    }

    //initialize some basic inputs for lists
    private void initialize() {
        //admins
        Admin admin1 = new Admin("Master", "master@gmx.at", "4321" );
        addAdminList(admin1);

        //Assis
        Assistant assi1 = new Assistant("Dominik", "dom@gmx.at", "1234");
        Assistant assi2 = new Assistant("Matze", "mathias@gmail.com", "password");
        addAssiList(assi1);
        addAssiList(assi2);

        //Students
        Student stud1 = new Student("Vilja", "vilja@web.de", "password");
        addStudList(stud1);

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
    }


}
