package com.example.facebook_api.Repository;


import com.example.facebook_api.Entity.Status;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface StatusRepo extends CassandraRepository<Status, UUID> {

    Status save(Status status);
    ArrayList<Status> findAll();
    void deleteById(UUID statusID);
}
