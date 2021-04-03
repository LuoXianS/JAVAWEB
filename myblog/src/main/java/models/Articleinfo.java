package models;

import java.util.Date;

public class Articleinfo {
    static int id;
    static  String title;
    static  String content;
    static Date create_time;
    static Date update_time;
    static int user_id ;
    static int rcount;
    static int state;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Articleinfo.id = id;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Articleinfo.title = title;
    }

    public static String getContent() {
        return content;
    }

    public static void setContent(String content) {
        Articleinfo.content = content;
    }

    public static Date getCreate_time() {
        return create_time;
    }

    public static void setCreate_time(Date create_time) {
        Articleinfo.create_time = create_time;
    }

    public static Date getUpdate_time() {
        return update_time;
    }

    public static void setUpdate_time(Date update_time) {
        Articleinfo.update_time = update_time;
    }

    public static int getUser_id() {
        return user_id;
    }

    public static void setUser_id(int user_id) {
        Articleinfo.user_id = user_id;
    }

    public static int getRcount() {
        return rcount;
    }

    public static void setRcount(int rcount) {
        Articleinfo.rcount = rcount;
    }

    public static int getState() {
        return state;
    }

    public static void setState(int state) {
        Articleinfo.state = state;
    }
}
