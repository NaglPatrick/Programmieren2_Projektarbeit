package com.Main;

/*
 * ISchedule
 * Program to let Professors(com.Classes.Admin), assistants and student schedule their preferred courses
 * Author: Nagl Patrick
 * Last Change:  27.05.2022
 */

import com.Classes.Course;
import com.GUI.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
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

        Map<String, com.Classes.Room> roomlist = Lists.getRoomList();
        System.out.println(roomlist);
        List<Course> clist = Lists.getCourseList();
        System.out.println(clist);
        for (Course c : clist) {
            System.out.println(c);
        }
        System.out.println(Lists.getCourseListBox());

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