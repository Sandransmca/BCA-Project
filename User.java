package com.example.grievanceapp;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
public class User{
String  suggestion;
String dep,text;

    public User(String suggestion,String dep, String text) {
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
