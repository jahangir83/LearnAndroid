package com.example.myapplication;

import java.util.Date;

public class Items {

    private String wishString;
    private Date date;


    public Items(String wishString, Date date){
        this.wishString = wishString;
        this.date = date;
    }


    // ---------Geter And Seter -----

    public String getWishString() {
        return wishString;
    }

    public void setWishString(String wishString) {
        this.wishString = wishString;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
