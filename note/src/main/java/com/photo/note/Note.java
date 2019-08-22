package com.photo.note;

public class Note {
    private String title;
    private String descreption;
    private  String dayOfWeek;
    private int priroty;

    public Note(String title, String descreption, String dayOfWeek, int priroty) {
        this.title = title;
        this.descreption = descreption;
        this.dayOfWeek = dayOfWeek;
        this.priroty = priroty;
    }

    public String getTitle() {
        return title;
    }

    public String getDescreption() {
        return descreption;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getPriroty() {
        return priroty;
    }
}
