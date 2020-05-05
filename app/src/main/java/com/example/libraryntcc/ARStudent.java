package com.example.libraryntcc;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ARStudent  {

    ArrayList<Student> response;


    public ARStudent() {
    }

    public ARStudent(ArrayList<Student> response) {
        this.response = response;
    }

    public ArrayList<Student> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<Student> response) {
        this.response = response;
    }
}
