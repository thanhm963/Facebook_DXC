package com.example.facebook_api.Controller;

import java.util.ArrayList;
import java.util.UUID;
import com.example.facebook_api.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.facebook_api.Entity.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
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
        return new ArrayList<User>();
    }
    
    @GetMapping("/getAllUsers/{userID}")
    public User getUserDetail(@PathVariable("userID") UUID userID){
        return new User();
    }
}
