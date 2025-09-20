package com.example.facebook_api.Controller;


import com.example.facebook_api.Entity.Comment;
import com.example.facebook_api.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/controllerService")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/save")
    public Comment saveComment (@RequestBody Comment comment){
        return commentService.saveComment(comment);
    }

    @GetMapping("/getAllComment")
    public ArrayList<Comment> getAllComment(UUID postID){
        return commentService.getAllComments(postID);
    }

//    @DeleteMapping("/delete/{commentID}")
//    public ArrayList<Comment> deleteComment (@PathVariable("postID") UUID commentID){
//        ArrayList<Comment> result = commentService.deleteComment(commentID);
//        return result;
//    }

}

