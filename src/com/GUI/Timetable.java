package com.GUI;

/*
 * ISchedule
 * Program to let Professors(com.Classes.Admin), assistants and student schedule their preferred courses
 * Author: Nagl Patrick
 * Last Change:  27.05.2022
 */

import com.Classes.Course;
import com.Classes.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.List;

public class Timetable extends JFrame{

    private JPanel mainPanel;
    private JPanel coursePanel;

    private JTable table;

    private JScrollPane scrollPane;

    private String[] columnNames = new String[3];

    private String[][] dataValues = new String[3][3];

    JTextField textBox = new JTextField();
    User user;
    List<Course> courseList;


    public Timetable(User user) {
        this.user = user;
        this.courseList = user.getCourseAttendingList();
        initialize();


    }

    public void initialize() {
        JFrame frame = new JFrame("Course Schedule");
//        setVisible(true);
//        setTitle("Timetable");
//




//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        coursePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Set up the weekday labels
                String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
                int labelHeight = 30;
                int labelWidth = getWidth() / weekdays.length;

                for (int i = 0; i < weekdays.length; i++) {
                    g.drawString(weekdays[i], i * labelWidth + 5, labelHeight);
                }

                // Draw the courses
                int rectHeight = 25;

                for (Course course : courseList) {
                    int startX = course.getDayIndex() * labelWidth +2;
                    int startY = labelHeight + (course.getStartTimeSlotIndex() * rectHeight) + 5;
                    int endX = startX + labelWidth -2;
                    int endY = labelHeight + (course.getEndTimeSlotIndex() * rectHeight) + 5;

                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(startX, startY, endX - startX, endY - startY);

                    g.setColor(Color.WHITE);
                    g.drawString("Course: " + course.getCourseName(), startX + 5, startY + rectHeight / 2);
                    g.drawString("Room: " + course.getRoomName(), startX + 5, startY + rectHeight / 2 + g.getFontMetrics().getHeight());


                }
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(550, 800);
            }
        };


        frame.add(coursePanel);
        frame.pack();
        frame.setVisible(true);


    }









    private void createUIComponents() {
        // TODO: place custom component creation code here
        coursePanel = new JPanel();
    }







}

