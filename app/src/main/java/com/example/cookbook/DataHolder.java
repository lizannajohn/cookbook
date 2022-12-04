package com.example.cookbook;

import android.provider.ContactsContract;

public class DataHolder {
    String fname, lname, email, pwd;

    //Add Constructor

    public DataHolder(String fname, String lname, String email, String pwd) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.pwd = pwd;
    }

    //Add getter and setter

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String mail)
    {
        email = mail;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String firstname)
    {
        fname = firstname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lastname)
    {
        lname = lastname;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String password)
    {
        pwd = password;
    }
}
