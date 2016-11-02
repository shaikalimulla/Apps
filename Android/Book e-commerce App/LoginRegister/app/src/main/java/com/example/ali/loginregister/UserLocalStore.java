package com.example.ali.loginregister;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ali on 11/13/2015.
 */
public class UserLocalStore {
    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabse;

    public UserLocalStore (Context context) {
        userLocalDatabse = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabse.edit();
        spEditor.putString("name", user.name);
        spEditor.putString("username", user.username);
        spEditor.putString("email", user.email);
        spEditor.putString("password", user.password);
        spEditor.commit();
    }

    public User getLoggedInUser() {
        String name = userLocalDatabse.getString("name", "");
        String username = userLocalDatabse.getString("username", "");
        String email = userLocalDatabse.getString("email", "");
        String password = userLocalDatabse.getString("password", "");

        User storedUser = new User(name, username, email, password);
        return storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn) {
        SharedPreferences.Editor spEditor = userLocalDatabse.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){
        if(userLocalDatabse.getBoolean("loggedIn", false) == true)
            return true;
        else
            return false;
    }

    public void clearUserData() {
        SharedPreferences.Editor spEditor = userLocalDatabse.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
