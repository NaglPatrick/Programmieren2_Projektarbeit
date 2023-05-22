package com.Main;

import com.Classes.Admin;
import com.Classes.Assistant;
import com.Classes.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Lists {

    private static Map<String, Admin> adminList;
    private static Map<String, Assistant> assiList;
    private static Map<String, Student> studList;

    public Lists() {
        this.adminList = new HashMap<String, Admin>();
        this.assiList = new HashMap<String, Assistant>();
        this.studList = new HashMap<String, Student>();
    }

    //setter

    public static void setAdminList(Admin admin) {
        adminList.put(admin.getUserName(), admin);
    }

    public static void setAssiList(Assistant assi) {
        assiList.put(assi.getUserName(), assi);
    }

    public static void setStudList(Student stud) {
        studList.put(stud.getUserName(), stud);
    }

    //getter

    public static Map<String, Admin> getAdminList() {
        return adminList;
    }

    public static Map<String, Assistant> getAssiList() {
        return assiList;
    }

    public static Map<String, Student> getStudList() {
        return studList;
    }
}
