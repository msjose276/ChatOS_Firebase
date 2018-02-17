package com.example.mateusjose.newchatos.Objects;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import com.example.mateusjose.newchatos.R;

/**
 * Created by mateusjose on 2/8/18.
 */

public class Contact {

    private String firstName;
    private String lastName;
    private String cellPhoneNumber;
    private Bitmap profilePicture;
    private boolean isOnline;

    public boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean online) {
        isOnline = online;
    }



    private int numberOfMessagesNotRead;

    public Contact(String firstName, String lastName, String cellPhoneNumber,Bitmap profilePicture ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellPhoneNumber = cellPhoneNumber;
        this.profilePicture=profilePicture;
        numberOfMessagesNotRead=3;
        this.isOnline=true;
    }
    public Contact(String firstName, String lastName, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellPhoneNumber = cellPhoneNumber;
        //this is not setting up the profile picture
        this.profilePicture=BitmapFactory.decodeResource(null, R.drawable.bonita);
        numberOfMessagesNotRead=0;
        this.isOnline=false;
    }

    public Contact(String firstName, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = "";
        this.cellPhoneNumber = cellPhoneNumber;
        //this is not setting up the profile picture
        this.profilePicture=BitmapFactory.decodeResource(null, R.drawable.bonita);
        numberOfMessagesNotRead=0;
        this.isOnline=false;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public Bitmap getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Bitmap profilePicture) {
        this.profilePicture = profilePicture;
    }


    public int getNumberOfMessagesNotRead() {
        return numberOfMessagesNotRead;
    }

    public void setNumberOfMessagesNotRead(int numberOfMessagesNotRead) {
        this.numberOfMessagesNotRead = numberOfMessagesNotRead;
    }


}
