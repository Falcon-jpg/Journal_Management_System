package com.springSecurity.Project.controller;

import com.springSecurity.Project.entity.User;
import com.springSecurity.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        List<User> all = userService.getAll();
        if(all!= null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //for this work there should at least be 1 user with ADMIN ( but we are hardcoding every user as USER role) , so here we
    // need to manually go to mongodb atlas and add ADMIN role to 1 user. so that we can use that user authorization access to
    // create more users via /admin api endpoint
    @PostMapping
    public void createAdmin(@RequestBody User user){
        userService.saveAdmin(user);
    }
}
