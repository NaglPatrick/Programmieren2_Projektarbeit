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
    private ArrayList<Admin> adminList = new ArrayList<Admin>();
    private ArrayList<Student> studList = new ArrayList<Student>();
    private ArrayList<Assistant> assiList = new ArrayList<Assistant>();

    private Pattern eMail = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");



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
                int role = comboBox.getSelectedIndex();

                //check is-E-Mail?
                Matcher mat = eMail.matcher(mail);
                if (mat.matches()) {
                    //check username exists?
                    if (!containsName(adminList, userName) && !containsNameAssi(assiList, userName) && !containsNameStud(studList, userName)) {
                        //check email exists?
                        if (!containsEMail(adminList, mail) && !containsEMailAssi(assiList, mail) && !containsEMailStud(studList, mail)) {
                            //check which role was picked (Default Student)
                            switch (role) {
                                case 0: {
                                    Admin admin = new Admin(userName, mail, pw);
                                    adminList.add(admin);
                                    break;
                                }
                                case 1: {
                                    Assistant assi = new Assistant(userName, mail, pw);
                                    assiList.add(assi);
                                    break;
                                }
                                case 2: {
                                    Student stud = new Student(userName, mail, pw);
                                    studList.add(stud);
                                }
                            }

                            for (Admin user : adminList) {
                                System.out.println("Admin: " + user.getUserName());
                            }
                            for (Assistant user : assiList) {
                                System.out.println("Assistant: " + user.getUserName());
                            }
                            for (Student user : studList) {
                                System.out.println("Student: " + user.getUserName());
                            }
                                setVisible(false);
//                                dispose();

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

    public boolean containsName(ArrayList<Admin> userList, String userName) {
        return userList.stream().map(Admin::getUserName).filter(userName::equals).findFirst().isPresent();
    }

    public boolean containsEMail(ArrayList<Admin> userList, String eMail) {
        return userList.stream().map(Admin::geteMail).filter(eMail::equals).findFirst().isPresent();
    }

    public boolean containsNameAssi(ArrayList<Assistant> userList, String userName) {
        return userList.stream().map(Assistant::getUserName).filter(userName::equals).findFirst().isPresent();
    }

    public boolean containsEMailAssi(ArrayList<Assistant> userList, String eMail) {
        return userList.stream().map(Assistant::geteMail).filter(eMail::equals).findFirst().isPresent();
    }

    public boolean containsNameStud(ArrayList<Student> userList, String userName) {
        return userList.stream().map(Student::getUserName).filter(userName::equals).findFirst().isPresent();
    }

    public boolean containsEMailStud(ArrayList<Student> userList, String eMail) {
        return userList.stream().map(Student::geteMail).filter(eMail::equals).findFirst().isPresent();
    }

    public void initialize() {
        setContentPane(mainPanel);
        setTitle("Registration");
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        String[] roles = {"Administrator", "Assistant", "Student"};
        comboBox = new JComboBox<String>(roles);
        comboBox.setSelectedIndex(2);


    }




}
