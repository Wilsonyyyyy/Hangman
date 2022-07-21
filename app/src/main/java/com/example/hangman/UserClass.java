package com.example.hangman;

public class UserClass {
    String mail;
    String UN;
    String pass;
    String ageee;

    public UserClass(){

    }

    public UserClass(String mail, String UN, String pass, String ageee) {
        this.mail = mail;
        this.UN = UN;
        this.pass = pass;
        this.ageee = ageee;
    }

    public String getMail() {
        return mail;
    }

    public String getUN() {
        return UN;
    }

    public String getPass() {
        return pass;
    }

    public String getAgeee() {
        return ageee;
    }
}
