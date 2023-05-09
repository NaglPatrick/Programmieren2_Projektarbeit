package com.GUI;
/*
 * ISchedule
 * Program to let Professors(com.Classes.Admin), assistants and student schedule their preferred courses
 * Author: Nagl Patrick
 * Last Change:  05.05.2022
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.Classes.*;


public class Register extends JFrame{

    private JPanel mainPanel;
    private JTextField eMailField;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JComboBox comboBox;
    private JButton buttonCreate;

    //different lists for different kinds of users
    private ArrayList<Student> studList = new ArrayList<Student>();
    private Pattern eMail = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");

    //getter
    public ArrayList<Student> getStudList() {
        return studList;
    }

    //Constructor
    public Register() {
//        initialize();

        //ActionListener for button "create User"
        buttonCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameField.getText();
                String mail = eMailField.getText();
                String pw = passwordField.getText();

                //check is-E-Mail?
                Matcher mat = eMail.matcher(mail);
                if (mat.matches()) {
                    // insert switch case for stud, assi, or admin
                    Student student = new Student(userName, mail, pw);

                    //check username exists?
                    if (!containsName(studList, student.getUserName())) {
                        //check email exists?
                        if (!containsEMail(studList, student.geteMail())) {
                            //check length of list

//                                studList.add(student);
                                //clear input fields (optional??)
//                                textFieldUser.setText("");
//                                textFieldMail.setText("");
//                                passwordField.setText("");


                        } else {
                            JOptionPane.showMessageDialog(null, "E-Mail address already exists!", "Duplicate Warning", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "User already exists!", "Duplicate Warning", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong E-Mail format!", "E-Mail Format Error", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
    }

    public boolean containsName(ArrayList<Student> userList, String userName) {
        return userList.stream().map(Student::getUserName).filter(userName::equals).findFirst().isPresent();
    }

    public boolean containsEMail(ArrayList<Student> userList, String eMail) {
        return userList.stream().map(Student::geteMail).filter(eMail::equals).findFirst().isPresent();
    }

    public void initialize() {
        setContentPane(mainPanel);
        setTitle("Registration");
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

//    private void createUIComponents() {
//        // TODO: place custom component creation code here
//        JComboBox<String> comboBox = new JComboBox<String>();
//        comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrator", "Assistant", "com.Classes.Student"}));
//
//    }





}
