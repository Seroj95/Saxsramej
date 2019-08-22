package com.photo.box;

public class Dril {
    private String title;
    private String info;
    private int imageRecoursId;

    public Dril(String title, String info, int imageRecoursId) {
        this.title = title;
        this.info = info;
        this.imageRecoursId = imageRecoursId;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getImageRecoursId() {
        return imageRecoursId;
    }


    @Override
    public String toString() {
        return title;
    }
}
