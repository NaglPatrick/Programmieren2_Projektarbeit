package com.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JButton buttonLogin;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton buttonCreate;
    private JPanel mainPanel;

    public Login() {
        initialize();
        buttonCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Register register = new Register();
//                register.initialize();
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
//                Menu menu = new Menu();
//                menu.initialize();
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Menu menu = new Menu();
                            menu.initialize();
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
        setTitle("Login");
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
