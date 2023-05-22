package com.Main;

import com.Classes.Admin;
import com.GUI.*;

import java.awt.*;
import java.util.ArrayList;

public class Application {



    public static void main(String[] args) {
        Lists lists = new Lists();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Login login = new Login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}