package com.example.facebook_api.Repository;

import java.util.ArrayList;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.facebook_api.Entity.Post;
import java.util.List;
import java.util.UUID;



public interface PostRepo extends CassandraRepository<Post, UUID> {
    ArrayList<Post> findAll();
    Post save(Post post);
    void deleteById(UUID postID);    
}
