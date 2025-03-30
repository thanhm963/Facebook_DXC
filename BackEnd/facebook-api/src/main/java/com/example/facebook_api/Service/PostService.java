package com.example.facebook_api.Service;

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
