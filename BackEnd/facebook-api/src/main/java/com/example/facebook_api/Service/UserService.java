package com.example.facebook_api.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.facebook_api.Entity.User;
import com.example.facebook_api.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    
    public User submitMetaDataOfUser(User user){
		Date date = new Date();
		long time = date.getTime();
		Timestamp dateTime=new Timestamp(time);

		user.setActive(true);
		user.setJoiningDate(dateTime);
		
        return userRepository.save(user);
    }

    public ArrayList<User> retrieveAllUserDetails(){

        return userRepository.findAll();
    }

    public User getUserData(String userID) {
        return userRepository.findAllByUserID(userID);
    }

    public ArrayList<User> deleteUser(String userID){
        userRepository.deleteById(userID);
        ArrayList<User> result =  retrieveAllUserDetails();
        return result;
    }
}
