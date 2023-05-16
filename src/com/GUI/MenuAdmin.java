package com.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuAdmin extends JFrame{
    private JPanel mainPanel;
    private JComboBox comboBoxTimeStart;
    private JComboBox comboBoxTimeEnd;
    private JComboBox comboBoxRoom;
    private JTextField textFieldRoom;
    private JButton createButton;
    private JButton acceptButton;

    private String temp;



    public MenuAdmin() {
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                temp = textFieldRoom.getText();
                comboBoxRoom.addItem(temp);
                System.out.println(temp);
                //Todo: Save temp in database

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
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //Rooms
        String[] rooms = {"Room 1", "Room 2", "Room 3"};
        comboBoxRoom = new JComboBox<String>(rooms);
        comboBoxRoom.setSelectedIndex(0);
        //Time
        String[] timeStart = {"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30"};
        comboBoxTimeStart = new JComboBox<String>(timeStart);
        comboBoxTimeStart.setSelectedIndex(0);

        String[] timeEnd = {"8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00"};
        comboBoxTimeEnd = new JComboBox<String>(timeEnd);
        comboBoxTimeEnd.setSelectedIndex(0);
    }
}
