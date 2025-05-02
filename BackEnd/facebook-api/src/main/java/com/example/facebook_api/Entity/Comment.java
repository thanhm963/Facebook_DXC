package com.example.facebook_api.Entity;


import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Table
public class Comment {
    @PrimaryKey
    private UUID commentID;

    private UUID postID;
    private UUID userID;

    private String comment;

    private Timestamp dateTime;

    public Comment(UUID commentID, UUID postID, UUID userID, String comment, Timestamp dateTime) {
        super();
        this.commentID = commentID;
        this.postID = postID;
        this.userID = userID;
        this.comment = comment;
        this.dateTime = dateTime;
    }

    public Comment() {
        super();
    }

    public UUID getCommentID() {
        return commentID;
    }

    public UUID getPostID() {
        return postID;
    }

    public UUID getUserID() {
        return userID;
    }

    public String getComment() {
        return comment;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setCommentID(UUID commentID) {
        this.commentID = commentID;
    }

    public void setPostID(UUID postID) {
        this.postID = postID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
}
