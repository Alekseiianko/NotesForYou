package com.example.notesforyou;

public class NoteForView {

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
