package com.GUI;

/*
 * ISchedule
 * Program to let Professors(com.Classes.Admin), assistants and student schedule their preferred courses
 * Author: Nagl Patrick
 * Last Change:  27.05.2022
 */

import com.Classes.User;
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

public class MenuStudent extends JFrame{
    private JPanel mainPanel;

    private JComboBox comboBoxRoom;
    private JButton acceptButton;
    private JButton logoutButton;

    private JComboBox comboBoxCourse;
    private JLabel userNameLabel;
    private JPanel coursePanel;
    private JButton registerButton;
    private JButton timetableButton;
    private JButton withdrawButton;
    private JPanel attendingPanel;

    //variables and such
    private User user;
    private String temp;

    private List<Course> courseAttendingList;
    private List<Course> courseListBox;




    public MenuStudent(User user) {
        this.user = user;
        this.courseListBox = Lists.getCourseListBox();
        this.courseAttendingList = user.getCourseAttendingList();


        //shows the courses with their time and weekday
        comboBoxCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //input
                String courseName = comboBoxCourse.getSelectedItem().toString();

                //from list
                List<Course> courses= Lists.getCoursesByName(courseName);


                Component[] components = coursePanel.getComponents();
                for (Component component : components) {
                    // Remove the JLabel from the panel
                    coursePanel.remove(component);
                }
                for (int i = 0; i < courses.size(); i++) {
                    Course c = courses.get(i);
                    JLabel label = new JLabel();
                    label.setText(c.getCourseName() + ": from " +  c.getTimeStart() +" to " + c.getTimeEnd() +" on " + c.getWeekday());
                    coursePanel.add(label);
                    coursePanel.revalidate();
                }
            }
        });


        //registers for all courses with name = name in combobox and adds name to attendingPanel
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = comboBoxCourse.getSelectedItem().toString();
                List<Course> courses = Lists.getCoursesByName(courseName);
                boolean haveTime = true;

                for (Course c : courses) {
                    Time timeStart = c.getTimeStart();
                    Time timeEnd = c.getTimeEnd();
                    String day = c.getWeekday();
                    for (Course course : courseAttendingList) {
                        if (isTimeWithinRange(course.getTimeStart(), course.getTimeEnd(), timeStart, timeEnd) && course.getWeekday().equals(day)) {
                            haveTime = false;
                            break;
                        }
                    }
                }
                if (haveTime) {
                    JOptionPane.showMessageDialog(null, "You are now attending the course:" + courseName, "Notification", JOptionPane.INFORMATION_MESSAGE);

                    for (Course c : courses) {
                        courseAttendingList.add(c);
                        user.addCourseAttendingList(c);
                    }
                    JLabel label = new JLabel(courseName);
                    attendingPanel.add(label);
                    attendingPanel.revalidate();

                } else {
                    JOptionPane.showMessageDialog(null, "You can not attend more than one course at the same time", "Collision Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        //withdraws from selected course(s)
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = comboBoxCourse.getSelectedItem().toString();
                List<Course> courses = Lists.getCoursesByName(courseName);
                for (Course c : courses) {
                    courseAttendingList.remove(c);
                    user.removeCourseAttendingList(c);
                }
                Component[] comp = attendingPanel.getComponents();
                for (Component component : comp) {
                    attendingPanel.remove(component);
                }
                for (int i = 0; i < courses.size(); i++) {
                    Course c = courseAttendingList.get(i);
                    JLabel label = new JLabel();
                    label.setText(c.getCourseName());
                    attendingPanel.add(label);
                    attendingPanel.revalidate();
                    //not the best solution, but i´m out of time
                }

            }
        });

        timetableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTimetable();
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
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        userNameLabel.setText(user.getUserName());

        //fill comboBoxes
        for (Course course : courseListBox) {
            comboBoxCourse.addItem(course.getCourseName());
        }
        coursePanel.setLayout(new BoxLayout(coursePanel, BoxLayout.Y_AXIS));
        attendingPanel.setLayout(new BoxLayout(attendingPanel, BoxLayout.Y_AXIS));
        for (Course course : courseAttendingList) {
            JLabel label = new JLabel(course.getCourseName());
            attendingPanel.add(label);
            attendingPanel.revalidate();
        }


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        coursePanel = new JPanel();
        attendingPanel = new JPanel();
        //username Label
        userNameLabel = new JLabel();

        //Rooms
        String[] rooms = {};
        comboBoxRoom = new JComboBox<String>(rooms);
//        comboBoxRoom.setSelectedIndex(0);
        //Courses
        String[] courses = {};
        comboBoxCourse = new JComboBox<String>(courses);

    }
    // Helper method to check if a given time range falls within the given start and end times
    private static boolean isTimeWithinRange(Time start, Time end, Time rangeStart, Time rangeEnd) {
        return (start.compareTo(rangeStart) >= 0 && end.compareTo(rangeStart) <= 0) ||
                (start.compareTo(rangeEnd) >= 0 && end.compareTo(rangeEnd) <= 0) ||
                (start.compareTo(rangeStart) <= 0 && end.compareTo(rangeEnd) >= 0);
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
}
