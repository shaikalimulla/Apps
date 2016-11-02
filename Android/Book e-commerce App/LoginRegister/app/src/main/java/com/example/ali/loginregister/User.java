package com.example.ali.loginregister;

/**
 * Created by ali on 11/13/2015.
 */
public class User {
    String name, username, email, password;

    public User (String name, String username, String password, String email){
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public boolean addUser(){
        DatabaseManager DbMan = DatabaseManager.getInstance();
        DbMan.addUser(name,username,password,email);
        return true;
    }
}
