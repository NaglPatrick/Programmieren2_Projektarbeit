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

    //setter
    public static void setAdminList(Admin admin) {
        adminList.put(admin.getUserName(), admin);
    }

    public static void setAssiList(Assistant assi) {
        assiList.put(assi.getUserName(), assi);
    }

    public static void setStudList(Student stud) {
        studList.put(stud.getUserName(), stud);
    }

    public static void setRoomList(Room room) {
        roomList.put(room.getRoomName(), room);
    }
    public static void setCourseList(Course course) {
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
        setAdminList(admin1);

        //Assis
        Assistant assi1 = new Assistant("Dominik", "dom@gmx.at", "1234");
        Assistant assi2 = new Assistant("Matze", "mathias@gmail.com", "password");
        setAssiList(assi1);
        setAssiList(assi2);

        //Students
        Student stud1 = new Student("Vilja", "vilja@web.de", "password");
        setStudList(stud1);

        //rooms
        Room room1 = new Room("Room 101");
        Room room2 = new Room("Room 102");
        Room room3 = new Room("Room 103");
        Room room4 = new Room("Room 202");
        Room room5 = new Room("Room 204");
        setRoomList(room1);
        setRoomList(room2);
        setRoomList(room3);
        setRoomList(room4);
        setRoomList(room5);

        //courses
        Course course1 = new Course("Mathe", room1, Time.valueOf(Application.correctTime("8:00")), Time.valueOf(Application.correctTime("11:30")), "Monday");
        Course course2 = new Course("Mathe", room1, Time.valueOf(Application.correctTime("8:00")), Time.valueOf(Application.correctTime("11:30")), "Tuesday");
        Course course3 = new Course("English", room2, Time.valueOf(Application.correctTime("12:00")), Time.valueOf(Application.correctTime("13:30")), "Monday");
        Course course4 = new Course("English", room2, Time.valueOf(Application.correctTime("12:00")), Time.valueOf(Application.correctTime("13:30")), "Tuesday");
        setCourseList(course1);
        setCourseList(course2);
        setCourseList(course3);
        setCourseList(course4);
    }


}
