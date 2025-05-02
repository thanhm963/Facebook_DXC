package com.example.facebook_api.Repository;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.facebook_api.Entity.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CassandraRepository <User, UUID> {
    User save(User user);
    ArrayList<User> findAll();
    User findAllByUserID(UUID userID);
    void deletebyID(UUID userID);
} 