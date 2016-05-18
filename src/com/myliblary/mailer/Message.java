package com.myliblary.mailer;

public class Message {

    //All your fields
    private String name;
    private String email;
    private String comment;
    //and so on...

    /*
    * Getters and setters for the fields.
    * You can use @Data annotation from Lombok library 
    * to generate them automatically for you.
    */
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getComment() { return comment; }
}