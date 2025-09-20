package com.example.facebook_api.Controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.example.facebook_api.Entity.Post;
import com.example.facebook_api.Service.PostService;

import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin
@RestController
@RequestMapping("/api/postService")
public class PostController {

    @Autowired
    PostService postService;
    
    @PostMapping("/save")
    public ArrayList<Post> submitPost(@RequestBody Post body){
        ArrayList<Post> result = postService.submitPosttoDB(body);
        return result;
    }

    @GetMapping("/getPost")
    public ArrayList<Post> retrieveAllPost() {
        ArrayList<Post> result = postService.retrivePosttoDB();
        return result;
    }

    @DeleteMapping("/delete/{postID}")
    public ArrayList<Post> deleteParticularPost(@PathVariable("postID") UUID postID )
    {
        ArrayList<Post> result = postService.deletePosttoDB(postID);
        return result;
    }
    
}
