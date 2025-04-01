package com.example.facebook_api.Repository;

import java.util.ArrayList;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.facebook_api.Entity.Post;
import java.util.List;
import java.util.UUID;


@Repository
public interface PostRepo extends CassandraRepository<Post, UUID> {

    ArrayList<Post> findAll();
    Post save(Post post);
    void deleteById(UUID postID);    
}
