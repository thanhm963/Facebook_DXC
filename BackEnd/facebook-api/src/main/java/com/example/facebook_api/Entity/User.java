package com.example.facebook_api.Entity;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class User {
    
    @PrimaryKey
    private String userID;

    private String userName;
    private String userImage;
    private boolean active;
    private Timestamp joiningDate;

    public User() {
        super();
    }
    public User(String userID, String userName, String userImage, boolean active, Timestamp joiningDate) {
        super();
        this.userID = userID;
        this.userName = userName;
        this.userImage = userImage;
        this.active = active;
        this.joiningDate = joiningDate;
    }
    public String getUserID() {
        return userID;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserImage() {
        return userImage;
    }
    public boolean isActive() {
        return active;
    }
    public Timestamp getJoiningDate() {
        return joiningDate;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public void setJoiningDate(Timestamp joiningDate) {
        this.joiningDate = joiningDate;
    }
    


    
}
