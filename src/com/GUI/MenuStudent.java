package com.GUI;

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
    private JComboBox comboBoxTimeStart;
    private JComboBox comboBoxTimeEnd;
    private JComboBox comboBoxRoom;
    private JButton acceptButton;
    private JButton logoutButton;
    private JComboBox comboBoxDay;
    private JComboBox comboBoxCourse;
    private JLabel userNameLabel;
    private JPanel coursePanel;
    private JButton registerButton;
    private JButton timetableButton;

    //variables and such
    private User user;
    private String temp;

    private Map<String, Room> roomList;
    private List<Course> courseAttendingList;



    public MenuStudent(User user) {
        this.user = user;
        this.roomList = Lists.getRoomList();
        this.courseAttendingList = user.getCourseAttendingList();


        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //input
                String courseName = comboBoxCourse.getSelectedItem().toString();

                //from list
                List<Course> courses= Lists.getCoursesByName(courseName);
                System.out.println(user.getUserName() + user.getCourseList());
                System.out.println(courses);
                coursePanel.setLayout(new BoxLayout(coursePanel, BoxLayout.Y_AXIS));
                for (int i = 0; i < courses.size(); i++) {
                    Course c = courses.get(i);
                    JLabel label = new JLabel();
                    label.setText(c.getCourseName() + c.getTimeStart() + c.getTimeEnd() + c.getWeekday());
                    coursePanel.add(label);
//                    label.setBounds(1, i*5, 30, 5);
//                    label.setSize(5, 30);
                    coursePanel.revalidate();
                }

            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = comboBoxCourse.getSelectedItem().toString();
                List<Course> courses= Lists.getCoursesByName(courseName);
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
                } else {
                    JOptionPane.showMessageDialog(null, "You can not attend more than one course at the same time", "Collision Error", JOptionPane.INFORMATION_MESSAGE);
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
        setSize(600, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        userNameLabel.setText(user.getUserName());

        //fill comboBoxes
        for (Room room : roomList.values()) {
            comboBoxRoom.addItem(room.getRoomName());
        }
        for (Course course : Lists.getCourseListBox()) {
            comboBoxCourse.addItem(course.getCourseName());
        }

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        coursePanel = new JPanel();
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
