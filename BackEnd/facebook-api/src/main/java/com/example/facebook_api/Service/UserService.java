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
        user.setUserID(UUID.randomUUID());
        return new User();
    }

    public ArrayList<User> retrieveAllUserDetails(){
        return new ArrayList<User>();
    }

    public User getUserData(UUID userID) {
        return new User();
    }
}
