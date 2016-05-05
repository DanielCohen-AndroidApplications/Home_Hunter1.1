package com.homehunter0224902.daniel.homehunter11;

import android.graphics.drawable.Drawable;
import android.text.format.Time;

import java.text.SimpleDateFormat;

/**
 * Created by Daniel on 4/21/2016.
 */
public class Appointment {
    private String address;
    private String contact;
    private Time time;
    private Drawable pic;

    public Appointment(String address, String contact, Time time, Drawable pic) {
        this.address = address;
        this.contact=contact;
        this.time=time;
        this.pic = pic;

    }

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getContact() {return contact;}
    public void setContact(String contact) {this.contact = contact;}

    public Time getTime(){return time;}
    public void setTime(Time time){this.time=time;}


    public void setPic(Drawable pic) {
        this.pic = pic;
    }
    public Drawable getPic() {return pic;}


}
