package com.example.hangman;

public class User {
    String un, highscore, date;

    public User(){}

    public User(String un, String highscore, String date) {
        this.un = un;
        this.highscore = highscore;
        this.date = date;
    }

    public String getUn() {
        return un;
    }

    public String getHighscore() {
        return highscore;
    }

    public String getDate() {
        return date;
    }
}
