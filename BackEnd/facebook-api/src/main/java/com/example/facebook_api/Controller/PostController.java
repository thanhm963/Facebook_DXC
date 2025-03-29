package com.example.facebook_api.Controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.facebook_api.Entity.Post;
import com.example.facebook_api.Service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/postService")
public class PostController {

    @Autowired
    PostService postService;
    
    @PostMapping("/save")
    public ArrayList<Post> submitPost(@RequestBody Post body){
        postService.submitPosttoDB(body);
        return new ArrayList<Post>();
    }

    @GetMapping("/getPost")
    public ArrayList<Post> retrieveAllPost(@RequestParam String param) {
        return new ArrayList<Post>();
    }

    @DeleteMapping("/delete")
    public ArrayList<Post> deleteParticularPost(@PathVariable("postID") UUID postID )
    {
        return new ArrayList<Post>();
    }
    
}
