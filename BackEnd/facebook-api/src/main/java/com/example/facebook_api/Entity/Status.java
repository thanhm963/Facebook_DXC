package com.example.facebook_api.Entity;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Status {
    @PrimaryKey
    private UUID statusID;

    private UUID userID;
    private String statusImageURL;
    private Timestamp uploadTime;

    public Status() {
        super();
    }

    public Status(UUID statusID, UUID userID, String statusImageURL, Timestamp uploadTime) {
        super();
        this.statusID = statusID;
        this.userID = userID;
        this.statusImageURL = statusImageURL;
        this.uploadTime = uploadTime;
    }

    public UUID getStatusID() {
        return statusID;
    }

    public UUID getUserID() {
        return userID;
    }

    public String getStatusImageURL() {
        return statusImageURL;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setStatusID(UUID statusID) {
        this.statusID = statusID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public void setStatusImageURL(String statusImageURL) {
        this.statusImageURL = statusImageURL;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

     
    
}
