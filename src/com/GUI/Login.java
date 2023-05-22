package com.GUI;

import com.Classes.Admin;
import com.Classes.Assistant;
import com.Classes.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Login extends JFrame{
    private JButton buttonLogin;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton buttonCreate;
    private JPanel mainPanel;

    //different lists for different kinds of users
    private Map<String, Admin> adminList;
    private Map<String, Student> studList;
    private Map<String, Assistant> assiList;

    public Login() {
        initialize();
        adminList = com.Main.Lists.getAdminList();
        assiList = com.Main.Lists.getAssiList();
        studList = com.Main.Lists.getStudList();
        buttonCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Register registration = new Register();
                            registration.initialize();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameField.getText();
                String pw = passwordField.getText();


                if (adminList.containsKey(userName)) {
                    Admin admin = adminList.get(userName);
                    System.out.println(admin.getUserName() + " " + admin.geteMail() + " " + admin.getPassword());
                    if (Objects.equals(pw, admin.getPassword())) {
                        EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    MenuAdmin menu = new MenuAdmin();
                                    menu.initialize();
                                    //close Login window
                                    setVisible(false);
                                    dispose();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong password, try again", "Login Warning", JOptionPane.INFORMATION_MESSAGE);

                    }
                } else if (assiList.containsKey(userName)) {
                    JOptionPane.showMessageDialog(null, "NOT YET AVAILABLE", "Login Warning", JOptionPane.INFORMATION_MESSAGE);
                } else if (studList.containsKey(userName)) {
                    JOptionPane.showMessageDialog(null, "NOT YET AVAILABLE", "Login Warning", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "User does not exist", "Login Warning", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public void initialize() {
        setContentPane(mainPanel);
        setTitle("Login");
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
