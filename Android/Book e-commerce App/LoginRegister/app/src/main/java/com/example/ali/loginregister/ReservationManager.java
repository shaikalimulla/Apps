package com.example.ali.loginregister;

/**
 * Created by Aayush on 11/28/2015.
 */
public class ReservationManager {


    private ReservationManager(){

    }
       public static void Reserve(String tl)
       {
                String title = tl;
           DatabaseManager dm = DatabaseManager.getInstance();
           dm.deleteEntry(title);
       }

}
