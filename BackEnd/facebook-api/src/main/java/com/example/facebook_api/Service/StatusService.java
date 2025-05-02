package com.example.facebook_api.Service;

import com.example.facebook_api.Entity.Status;
import com.example.facebook_api.Repository.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Service
public class StatusService {

    @Autowired
    StatusRepo statusRepo;


    public Status saveStatus(Status status){
        Date date = new Date();
        long time = date.getTime();
        Timestamp dateTime = new Timestamp(time);

        status.setStatusID(UUID.randomUUID());
        status.setUploadTime(dateTime);
        return statusRepo.save(status);
    }

    public ArrayList<Status> getAllStatus(){
        return statusRepo.findAll();
    }

    public ArrayList<Status> delteStatus(UUID statusID){
        statusRepo.deleteById(statusID);
        ArrayList<Status> result = getAllStatus();
        return result;
    }
}

