package com.ark_i.b2b.Models;

public class ModelClassForNotes {
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    String dateTime;

    public ModelClassForNotes(String text, String dateTime) {
        this.text = text;
        this.dateTime = dateTime;
    }


}
