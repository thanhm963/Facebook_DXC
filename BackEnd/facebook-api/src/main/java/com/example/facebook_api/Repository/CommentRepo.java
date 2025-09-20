package com.example.facebook_api.Repository;

import com.example.facebook_api.Entity.Comment;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface CommentRepo extends CassandraRepository<Comment, UUID> {
    Comment save(Comment comment);
    void deleteById(UUID commentID);

    @AllowFiltering
    ArrayList<Comment> findAllByPostID(UUID postID);
}
