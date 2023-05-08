/*
 * ISchedule
 * Program to let Professors(Admin), assistants and student schedule their preferred courses
 * Author: Nagl Patrick
 * Last Change:  05.05.2022
 */


import GUI.Login;
import GUI.Register;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Register registration = new Register();
//                    registration.initialize();
                    Login login = new Login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}