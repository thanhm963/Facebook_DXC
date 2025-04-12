package com.example.facebook_api.Entity;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class User {
    
    @PrimaryKey
    private UUID userID;

    private String userName;
    private String userImage;
    private boolean active;
    private Timestamp joiningDate;

    public User() {
        super();
    }
    public User(UUID userID, String userName, String userImage, boolean active, Timestamp joiningDate) {
        super();
        this.userID = userID;
        this.userName = userName;
        this.userImage = userImage;
        this.active = active;
        this.joiningDate = joiningDate;
    }

    
}
