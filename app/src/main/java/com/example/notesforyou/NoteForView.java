package com.example.notesforyou;

import java.io.Serializable;

public class NoteForView implements Serializable {

    String title;
    String text;

    public NoteForView(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
