package com.Classes;
/*
 * ISchedule
 * Program to let Professors(com.Classes.Admin), assistants and student schedule their preferred courses
 * Author: Nagl Patrick
 * Last Change:  05.05.2022
 */

public class Room {

    private String roomName;

    //constructor
    public Room(String roomName) {
        this.roomName = roomName;
    }

   //getter
    public String getRoomName() {
        return roomName;
    }
}
