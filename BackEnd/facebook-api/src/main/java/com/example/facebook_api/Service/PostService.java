package com.example.facebook_api.Service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.facebook_api.Entity.Post;

@Service
public class PostService {
    
    
    public ArrayList<Post> submitPosttoDB(Post postData)
    {
        return new ArrayList<Post>();
    }

    public ArrayList<Post> retrivePosttoDB(Post postData)
    {
        return new ArrayList<Post>();
    }

    public ArrayList<Post> deletePosttoDB(UUID postID)
    {
        return new ArrayList<Post>();
    }
}
