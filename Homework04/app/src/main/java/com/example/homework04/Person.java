package com.example.homework04;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String firstname;
    private String lastname;
    private String gender;
    private String email;
    private String phone;
    private String dob;

    // Constructor
    public Person(String firstname, String lastname, String gender, String email, String phone, String dob) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
    }

    // Getters and setters

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    // Parcelable implementation
    protected Person(Parcel in) {
        firstname = in.readString();
        lastname = in.readString();
        gender = in.readString();
        email = in.readString();
        phone = in.readString();
        dob = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstname);
        dest.writeString(lastname);
        dest.writeString(gender);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(dob);
    }
}
