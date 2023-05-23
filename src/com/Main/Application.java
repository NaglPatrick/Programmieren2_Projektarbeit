package com.Main;

import com.Classes.Admin;
import com.GUI.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class Application {

    //trying to make a general list output for the comboBoxes
//    public static String stringifyLists(Map<String, Class> list) {
//        for (int i = 0; i < list.size(); i++) {
//            return list.getKey();
//        }
//    }


    public static String correctTime(String time) {
        return time + ":00";
    }

    public static void main(String[] args) {
//

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