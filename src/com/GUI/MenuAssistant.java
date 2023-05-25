package com.GUI;

import com.Classes.Admin;
import com.Classes.Assistant;
import com.Classes.Course;
import com.Classes.Room;
import com.Main.Application;

import com.Classes.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Map;

import com.Main.Lists;

public class MenuAssistant extends JFrame{
    private JPanel mainPanel;
    private JComboBox comboBoxTimeStart;
    private JComboBox comboBoxTimeEnd;
    private JComboBox comboBoxRoom;
    private JButton acceptButton;
    private JButton logoutButton;
    private JComboBox comboBoxDay;
    private JComboBox comboBoxCourse;
    private JLabel userNameLabel;

    //variables and such
    private User user;
    private String temp;

    private Map<String, Room> roomList;
    private Map<String, Course> courseList;



    public MenuAssistant(User user) {
        this.user = user;
        this.roomList = Lists.getRoomList();
        this.courseList = Lists.getCourseList();


        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //input
                String roomName = comboBoxRoom.getSelectedItem().toString();
                String courseName = comboBoxCourse.getSelectedItem().toString();
                String timeStartString = comboBoxTimeStart.getSelectedItem().toString();
                Time timeStart = Time.valueOf(com.Main.Application.correctTime(timeStartString));
                String timeEndString = comboBoxTimeEnd.getSelectedItem().toString();
                Time timeEnd = Time.valueOf(com.Main.Application.correctTime(timeEndString));
                String day = comboBoxDay.getSelectedItem().toString();

                //from list
                Room room = roomList.get(roomName);
                Course course1 = courseList.get(courseName);
                System.out.println(room.getRoomName() + room.getCourseList());
                System.out.println(user.getUserName() + user.getCourseList());
                System.out.println(course1.getCourseName() + course1.getCourseList());

                if (timeStart.before(timeEnd)) {
//                    if (room.isEmpty()) {
//                        checkCourses(lector,timeStart, timeEnd);
//                    } else {
                    Map<String, Course> roomCourseList = room.getCourseList();
                    boolean hasTime = true;
                    for (Course course : roomCourseList.values()) {
                        if (isTimeWithinRange(course.getTimeStart(), course.getTimeEnd(), timeStart, timeEnd)) {
                            hasTime = false;
                            break;
                        }
                    }
                    if (hasTime) {
//                            checkCourses(lector, timeStart, timeEnd);
                        Map<String, Course> userCourseList = user.getCourseList();
                        boolean hasTime2 = true;
                        for (Course course : userCourseList.values()) {
                            if (isTimeWithinRange(course.getTimeStart(), course.getTimeEnd(), timeStart, timeEnd)) {
                                hasTime2 = false;
                                break;
                            }
                        }
                        if (hasTime2) {
                          Map<String, Course> courseCourseList = course1.getCourseList();
                                    boolean hasTime3 = true;
                                    for (Course course : courseCourseList.values()) {
                                        if (isTimeWithinRange(course.getTimeStart(), course.getTimeEnd(), timeStart, timeEnd)) {
                                            hasTime3 = false;
                                            break;
                                }
                            }
                            if (hasTime3) {
                                openTimetable();

                            } else {
                                JOptionPane.showMessageDialog(null, "There is already the same course in another room at that time", "Collision Warning", JOptionPane.INFORMATION_MESSAGE);

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "There is already a course you attend at that time", "Collision Warning", JOptionPane.INFORMATION_MESSAGE);

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "There is already a course in this room", "Collision Error", JOptionPane.INFORMATION_MESSAGE);

                    }

//                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Start time cannot be after end time!", "Time Error", JOptionPane.INFORMATION_MESSAGE);

                }


            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Login login = new Login();
                            setVisible(false);
                            dispose();
                            //todo: dispose of timetable if still open

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });


    }



    public void initialize() {
        setContentPane(mainPanel);
        setTitle("Main Menu");
        setSize(600, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        userNameLabel.setText(user.getUserName());

        //fill comboBoxes
        for (Room room : roomList.values()) {
            comboBoxRoom.addItem(room.getRoomName());
        }
        for (Course course : courseList.values()) {
            comboBoxCourse.addItem(course.getCourseName());
        }

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //username Label
        userNameLabel = new JLabel();

        //Rooms
        String[] rooms = {};
        comboBoxRoom = new JComboBox<String>(rooms);
//        comboBoxRoom.setSelectedIndex(0);
        //Courses
        String[] courses = {};
        comboBoxCourse = new JComboBox<String>(courses);

        //Time
        String[] timeStart = {"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30"};
        comboBoxTimeStart = new JComboBox<String>(timeStart);
        comboBoxTimeStart.setSelectedIndex(0);

        String[] timeEnd = {"8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00"};
        comboBoxTimeEnd = new JComboBox<String>(timeEnd);
        comboBoxTimeEnd.setSelectedIndex(0);

        String[] weekday = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        comboBoxDay = new JComboBox<String>(weekday);
        comboBoxDay.setSelectedIndex(0);
    }
    // Helper method to check if a given time range falls within the given start and end times
    private static boolean isTimeWithinRange(Time start, Time end, Time rangeStart, Time rangeEnd) {
        return (start.compareTo(rangeStart) >= 0 && end.compareTo(rangeStart) <= 0) ||
                (start.compareTo(rangeEnd) >= 0 && end.compareTo(rangeEnd) <= 0) ||
                (start.compareTo(rangeStart) <= 0 && end.compareTo(rangeEnd) >= 0);
    }



    private static void openTimetable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Timetable timetable = new Timetable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
