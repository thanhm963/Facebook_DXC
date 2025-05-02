package com.example.facebook_api.Controller;

import java.util.ArrayList;
import java.util.UUID;
import com.example.facebook_api.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.facebook_api.Entity.Post;
import com.example.facebook_api.Entity.User;


@RestController
@RequestMapping("/api/userService")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public User saveUserMetaData(@RequestBody User user) {
        return userService.submitMetaDataOfUser(user);
    }
    
    @GetMapping("/getUserDetails")
    public ArrayList<User> getAllUserDetails() {
        ArrayList<User> result = userService.retrieveAllUserDetails();
        return result;
    }
    
    @GetMapping("/getAllUsers/{userID}")
    public User getUserDetail(@PathVariable("userID") UUID userID){

        return userService.getUserData(userID);
    }

    @DeleteMapping("/delete/{userID}")
    public ArrayList<User> deleteUser(@PathVariable("userID") UUID userID){
        ArrayList<User> result = userService.deleteUser(userID);
        return result;
    }
}
