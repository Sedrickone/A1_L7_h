package com.onegmail.sedrick.a1_l7_h.objects;

import java.util.List;

/**
 * Created by ОБИ on 04.09.2016.
 */
public class Note {

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private String header;
    private String text;
    private int image;
    private List<Note> notes;

    public Note(String header,String text,int image) {
        this.text = text;
        this.header = header;
        this.image = image;
    }

    public Note(){}

}
