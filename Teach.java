package com.example.grievanceapp;

public class Teach {
    String  suggestion;
    String dep,text;

    public Teach(String suggestion,String dep, String text) {
        this.suggestion = suggestion;
        this.dep=dep;
        this.text=text;
    }
    public String getSuggestion() {
        return suggestion;
    }

    public String getDep() {
        return dep;
    }

    public String getText() {
        return text;
    }
}
