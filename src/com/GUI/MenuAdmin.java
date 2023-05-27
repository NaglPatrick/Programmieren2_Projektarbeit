package com.GUI;

/*
 * ISchedule
 * Program to let Professors(com.Classes.Admin), assistants and student schedule their preferred courses
 * Author: Nagl Patrick
 * Last Change:  27.05.2022
 */

import com.Classes.Course;
import com.Classes.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Map;
import java.util.List;

import com.Main.Lists;
import com.Classes.User;

public class MenuAdmin extends JFrame{
    private JPanel mainPanel;
    private JComboBox comboBoxTimeStart;
    private JComboBox comboBoxTimeEnd;
    private JComboBox comboBoxRoom;
    private JTextField textFieldRoom;
    private JButton createRoomButton;
    private JButton acceptButton;
    private JButton logoutButton;
    private JTextField textFieldCourse;
    private JButton createCourseButton;
    private JComboBox comboBoxDay;
    private JComboBox comboBoxCourse;
    private JLabel userNameLabel;
    private JComboBox comboBoxRoomDelete;
    private JComboBox comboBoxSpecCourseDelete;
    private JComboBox comboBoxCourseDelete;
    private JButton deleteRoomButton;
    private JButton deleteSpecCourseButton;
    private JButton deleteCourseButton;

    //variables and such
    private User user;
    private String temp;

    private Map<String, Room> roomList;
    private List<Course> courseList;
    private List<Course> courseListBox;
    private Map<String, User> userList;




    public MenuAdmin(User user) {
        this.user = user;
        this.roomList = Lists.getRoomList();
        this.courseList = Lists.getCourseList();
        this.userList = Lists.getUserList();
        this.courseListBox = Lists.getCourseListBox();


        createRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp = textFieldRoom.getText();
//                comboBoxRoom.addItem(temp);
                System.out.println(temp);
                //Todo: Save temp in database
                Room room = new Room(temp);
                Lists.addRoomList(room);
                JOptionPane.showMessageDialog(null, "You have added " + temp + " to the List.", "Notification", JOptionPane.INFORMATION_MESSAGE);

                resetBoxes();
            }
        });

        createCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp = textFieldCourse.getText();
//                comboBoxCourse.addItem(temp);
                System.out.println(temp);

                Course course = new Course(temp);
                Lists.addCourseListBox(course);
                JOptionPane.showMessageDialog(null, "You have added " + temp + " to the List.", "Notification", JOptionPane.INFORMATION_MESSAGE);
                resetBoxes();

            }
        });

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
                System.out.println(room.getRoomName() + room.getCourseList());
                System.out.println(user.getUserName() + user.getCourseList());
//                System.out.println(course1.getCourseName() + course1.getCourseList());

                if (timeStart.before(timeEnd)) {
//                    if (room.isEmpty()) {
//                        checkCourses(lector,timeStart, timeEnd);
//                    } else {
                        Map<String, Course> roomCourseList = room.getCourseList();
                        boolean hasTime = true;
                        for (Course course : roomCourseList.values()) {
                            if (isTimeWithinRange(course.getTimeStart(), course.getTimeEnd(), timeStart, timeEnd) && course.getWeekday().equals(day)) {
                                hasTime = false;
                                break;
                            }
                        }
                        if (hasTime) {
//                            checkCourses(lector, timeStart, timeEnd);
                            Map<String, Course> userCourseList = user.getCourseList();
                            boolean hasTime2 = true;
                            for (Course course : userCourseList.values()) {
                                if (isTimeWithinRange(course.getTimeStart(), course.getTimeEnd(), timeStart, timeEnd) && course.getWeekday().equals(day) ) {
                                    hasTime2 = false;
                                    break;
                                }
                            }
                            if (hasTime2) {
                                List<Course> courseCourseList = Lists.getCoursesByName(courseName);
                                boolean hasTime3 = true;
                                for (Course course : courseCourseList) {
                                    if (isTimeWithinRange(course.getTimeStart(), course.getTimeEnd(), timeStart, timeEnd) && course.getWeekday().equals(day)) {
                                        hasTime3 = false;
                                        break;
                                    }
                                }
                                if (hasTime3) {
                                    Course c = new Course(courseName, room, timeStart, timeEnd, day, user);
                                    Lists.addCourseList(c);
                                    user.addCourseAttendingList(c);
                                    resetBoxes();
                                    JOptionPane.showMessageDialog(null, "You have successfully created this course.", "Notification", JOptionPane.INFORMATION_MESSAGE);
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


        //DELETE Buttons
        deleteRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomName = comboBoxRoomDelete.getSelectedItem().toString();
                Room room = roomList.get(roomName);
                if (room.getCourseList().isEmpty()) {
                    Lists.removeRoomFromList(room);
                    JOptionPane.showMessageDialog(null, "You have deleted " + roomName + " from the List.", "Notification", JOptionPane.INFORMATION_MESSAGE);
                   System.out.println(Lists.getRoomList());
                    resetBoxes();
                } else {
                    System.out.println(room.getCourseList());
                    JOptionPane.showMessageDialog(null, "You cannot remove a room with courses in it.", "Collision Error", JOptionPane.INFORMATION_MESSAGE);

                }

            }
        });

        deleteCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = comboBoxCourseDelete.getSelectedItem().toString();
                Lists.removeCourseFromList(courseName);
                resetBoxes();
            }
        });

        deleteSpecCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String course = comboBoxSpecCourseDelete.getSelectedItem().toString();
                String name = course.split("/")[0];
                String time = course.split("/")[1];
                Lists.removeSpecificCourseFromList(name, time);
                resetBoxes();

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
            comboBoxRoomDelete.addItem(room.getRoomName());

        }
        for (Course course : courseListBox) {
            comboBoxCourse.addItem(course.getCourseName());
            comboBoxCourseDelete.addItem(course.getCourseName());
        }
        for (Course course : courseList) {
            comboBoxSpecCourseDelete.addItem(course.getCourseName() + "/" + course.getTimeStart() + "/" + course.getTimeEnd() + "/" + course.getWeekday());

        }

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //username Label
        userNameLabel = new JLabel();

        //Rooms
        String[] rooms = {};
        comboBoxRoom = new JComboBox<String>(rooms);
        comboBoxRoomDelete = new JComboBox<String>(rooms);

        //Courses
        String[] courses = {};
        comboBoxCourse = new JComboBox<String>(courses);
        comboBoxCourseDelete = new JComboBox<String>(courses);
        comboBoxSpecCourseDelete = new JComboBox<String>(courses);

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


    public void checkCourses(User lector, Time timeStart, Time timeEnd) {

            Map<String, Course> userCourseList = lector.getCourseList();
            if (!userCourseList.isEmpty())
                System.out.println("other courses exist for user");
            boolean hasTime2 = true;
            for (Course course : userCourseList.values()) {
                if (isTimeWithinRange(course.getTimeStart(), course.getTimeEnd(), timeStart, timeEnd)) {
                    hasTime2 = false;
                    break;
                }
            }
            if (hasTime2) {
                System.out.println("no collision");
                openTimetable();
            } else {
                System.out.println("collision");
                JOptionPane.showMessageDialog(null, "There is already a course you attend at that time", "Collision Warning", JOptionPane.INFORMATION_MESSAGE);
                openTimetable();
            }

        }

    private void openTimetable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Timetable timetable = new Timetable(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void resetBoxes() {
        //clear the comboboxes to avoid duplicates
        comboBoxCourse.removeAllItems();
        comboBoxCourseDelete.removeAllItems();
        comboBoxSpecCourseDelete.removeAllItems();
        comboBoxRoom.removeAllItems();
        comboBoxRoomDelete.removeAllItems();
        initialize();
    }
}
