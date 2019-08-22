package com.photo.note2;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity (tableName = "notes")
public class Note {
   @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String descreption;
    private int dayOfWeak;
    private int proreti;

    public Note(int id, String title, String descreption, int dayOfWeak, int proreti) {
        this.id = id;
        this.title = title;
        this.descreption = descreption;
        this.dayOfWeak = dayOfWeak;
        this.proreti = proreti;
    }

    @Ignore
    public Note(String title, String descreption, int dayOfWeak, int proreti) {
        this.descreption = descreption;
        this.dayOfWeak = dayOfWeak;
        this.proreti = proreti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescreption() {
        return descreption;
    }

    public int getDayOfWeak() {
        return dayOfWeak;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public void setDayOfWeak(int dayOfWeak) {
        this.dayOfWeak = dayOfWeak;
    }

    public void setProreti(int proreti) {
        this.proreti = proreti;
    }

    public int getProreti() {
        return proreti;

    }
    public static  String getDayAsString(int position){
        switch (position){
            case 1:
                return "erku";
                case 2:
                return "ereq";
            case 3:
                return "choreq";
            case 4:
                return "hing";
            case 5:
                return "urbat";
            case 6:
                return "shbat";
            default:
                return "kiraki";

        }

    }
}
