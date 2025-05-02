package com.example.facebook_api.Service;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facebook_api.Entity.Post;
import com.example.facebook_api.Repository.PostRepo;

@Service
public class PostService {
    
    @Autowired
    PostRepo postRepo;
    
    public ArrayList<Post> submitPosttoDB(Post postData)
    {   
        Date date = new Date();
        long time = date.getTime();
        Timestamp dateTime = new Timestamp(time);

        postData.setPostID(UUID.randomUUID());
        postData.setLikes(0);
        postData.setDateTime(dateTime);
        postRepo.save(postData);
        ArrayList<Post> result = retrivePosttoDB();
        return result;
    }

    public ArrayList<Post> retrivePosttoDB()
    {
        ArrayList<Post> result = postRepo.findAll();
        return result;
    }

    public ArrayList<Post> deletePosttoDB(UUID postID)
    {   
        postRepo.deleteById(postID);
        ArrayList<Post> result = retrivePosttoDB();
        return result;
    }
}





