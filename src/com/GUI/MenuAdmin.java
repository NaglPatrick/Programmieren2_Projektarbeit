package com.GUI;

import com.Classes.Course;
import com.Classes.Room;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;


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

    private String temp;

    private Map<String, Room> roomList;
    private Map<String, Course> courseList;



    public MenuAdmin() {

        roomList = com.Main.Lists.getRoomList();
        courseList = com.Main.Lists.getCourseList();
        //fill comboBoxes
        for (Room room : roomList.values()) {
            comboBoxRoom.addItem(room.getRoomName());
        }
        for (Course course : courseList.values()) {
            comboBoxCourse.addItem(course.getCourseName());
        }

        createRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp = textFieldRoom.getText();
                comboBoxRoom.addItem(temp);
                System.out.println(temp);
                //Todo: Save temp in database
                Room room = new Room(temp);
                com.Main.Lists.setRoomList(room);
            }
        });

        createCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp = textFieldCourse.getText();
                comboBoxCourse.addItem(temp);
                System.out.println(temp);
                //Todo: Save temp in database
                Course course = new Course(temp);
                com.Main.Lists.setCourseList(course);
            }
        });

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    public void initialize() {
        setContentPane(mainPanel);
        setTitle("Main Menu");
        setSize(600, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
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
}
