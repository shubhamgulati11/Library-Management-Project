package com.example.libraryntcc;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Student implements Parcelable {

    String id,password,Name,Enrollment,Department,phone,success;

    protected Student(Parcel in) {
        id = in.readString();
        password = in.readString();
        Name = in.readString();
        Enrollment = in.readString();
        Department = in.readString();
        phone = in.readString();
        success = in.readString();
    }

    public Student() {
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEnrollment() {
        return Enrollment;
    }

    public void setEnrollment(String enrollment) {
        Enrollment = enrollment;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(password);
        dest.writeString(Name);
        dest.writeString(Enrollment);
        dest.writeString(Department);
        dest.writeString(phone);
        dest.writeString(success);
    }
}
