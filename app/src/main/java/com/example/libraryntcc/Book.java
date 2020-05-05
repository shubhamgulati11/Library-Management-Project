package com.example.libraryntcc;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    String BId,BName,Author;

    public Book(String BId, String BName, String author) {
        this.BId = BId;
        this.BName = BName;
        Author = author;
    }

    public Book() {
    }

    protected Book(Parcel in) {
        BId = in.readString();
        BName = in.readString();
        Author = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getBId() {
        return BId;
    }

    public void setBId(String BId) {
        this.BId = BId;
    }

    public String getBName() {
        return BName;
    }

    public void setBName(String BName) {
        this.BName = BName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(BId);
        dest.writeString(BName);
        dest.writeString(Author);
    }
}
