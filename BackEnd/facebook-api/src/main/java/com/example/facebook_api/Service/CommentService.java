package com.example.facebook_api.Service;


import com.example.facebook_api.Entity.Comment;
import com.example.facebook_api.Repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;

    public Comment saveComment(Comment comment){
        Date date = new Date();
        long time = date.getTime();
        Timestamp datetime = new Timestamp(time);

        comment.setCommentID(UUID.randomUUID());
        comment.setDateTime(datetime);
        return  commentRepo.save(comment);
    }

    public ArrayList<Comment> getAllComments(UUID postID){
        return commentRepo.findAllByPostID(postID);
    }

//    public ArrayList<Comment> deleteComment(UUID commentID){
//        commentRepo.deleteById(commentID);
//        ArrayList<Comment> result = getAllComments();
//        return result;
//    }
}
