package com.example.facebook_api.Service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.facebook_api.Entity.User;
import com.example.facebook_api.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    @PostMapping("/save")
    public User submitMetaDataOfUser(User user){
		Date date = new Date();
		long time = date.getTime();
		Timestamp dateTime=new Timestamp(time);
		
        user.setUserID(UUID.randomUUID());
		user.setActive(true);
		user.setJoiningDate(joiningDate);
		
        return userRepository.save(user);
    }

    public ArrayList<User> retrieveAllUserDetails(){
        return userRepository.findAll();
    }

    public User getUserData(UUID userID) {
        return userRepository.findAllByUserId();
    }
}
