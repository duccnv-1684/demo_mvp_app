package com.example.ducnguyen.demomvpapp.data.model;

public class User {
    private String mId;
    private String mEmail;
    private String mDisplayName;

    public User() {
    }

    public User(String id, String email, String displayName) {
        mId = id;
        mEmail = email;
        mDisplayName = displayName;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(String displayName) {
        mDisplayName = displayName;
    }
}
