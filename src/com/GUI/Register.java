package com.GUI;
/*
 * ISchedule
 * Program to let Professors(Admin), assistants and student schedule their preferred courses
 * Author: Nagl Patrick
 * Last Change:  05.05.2022
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.Classes.*;
import com.Main.Lists;



public class Register extends JFrame{

    private JPanel mainPanel;
    private JTextField eMailField;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JComboBox comboBox;
    private JButton buttonCreate;


    //different lists for different kinds of users
    private Map<String, User> userList;
    private Map<String, Admin> adminList;
    private Map<String, Student> studList;
    private Map<String, Assistant> assiList;

    private Pattern eMail = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");



    //Constructor
    public Register() {
//        initialize();
        adminList = com.Main.Lists.getAdminList();
        assiList = com.Main.Lists.getAssiList();
        studList = com.Main.Lists.getStudList();
        userList = Lists.getUserList();

        //ActionListener for button "create User"

        buttonCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameField.getText();
                String mail = eMailField.getText();
                String pw = passwordField.getText();
                String role = comboBox.getSelectedItem().toString();

                //check is-E-Mail?
                Matcher mat = eMail.matcher(mail);
                if (mat.matches()) {
                    //check username exists?
                    if (!adminList.containsKey(userName) && !assiList.containsKey(userName) && !studList.containsKey(userName)) {
                        //check email exists?
                        if (!adminList.containsValue(mail) && !assiList.containsValue(mail) && !studList.containsValue(mail)) {
                            //password not empty (can be changed to pw not save etc.)
                            if (pw != "") {
                                        User user = new User(userName, mail, pw, role);
                                        Lists.addUserList(user);


                                //just for testing
                                for (User user1 : userList.values()) {
                                    System.out.println(user.getRole() + ": name: " + user.getUserName() + ", mail: " + user.geteMail() + ", pw: " + user.getPassword());
                                }
//                                for (Admin admin : adminList.values()) {
//                                    System.out.println("Admin: name: " + user.getUserName() + ", mail: " + user.geteMail() + ", pw: " + user.getPassword());
//                                }
//                                for (Assistant assi : assiList.values()) {
//                                    System.out.println("Assistant:  name: " + user.getUserName() + ", mail: " + user.geteMail() + ", pw: " + user.getPassword());
//                                }
//                                for (Student stud : studList.values()) {
//                                    System.out.println("Student:  name: " + user.getUserName() + ", mail: " + user.geteMail() + ", pw: " + user.getPassword());
//                                }
                                setVisible(false);
                                dispose();

                            } else {
                                JOptionPane.showMessageDialog(null, "Please enter a password", "Warning", JOptionPane.INFORMATION_MESSAGE);
                            }
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

//    public boolean containsName(ArrayList<Admin> userList, String userName) {
//        return userList.stream().map(Admin::getUserName).filter(userName::equals).findFirst().isPresent();
//    }

//    public boolean containsEMail(ArrayList<Admin> userList, String eMail) {
//        return userList.stream().map(Admin::geteMail).filter(eMail::equals).findFirst().isPresent();
//    }

//    public boolean containsNameAssi(ArrayList<Assistant> userList, String userName) {
//        return userList.stream().map(Assistant::getUserName).filter(userName::equals).findFirst().isPresent();
//    }
//
//    public boolean containsEMailAssi(ArrayList<Assistant> userList, String eMail) {
//        return userList.stream().map(Assistant::geteMail).filter(eMail::equals).findFirst().isPresent();
//    }
//
//    public boolean containsNameStud(ArrayList<Student> userList, String userName) {
//        return userList.stream().map(Student::getUserName).filter(userName::equals).findFirst().isPresent();
//    }
//
//    public boolean containsEMailStud(ArrayList<Student> userList, String eMail) {
//        return userList.stream().map(Student::geteMail).filter(eMail::equals).findFirst().isPresent();
//    }

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
