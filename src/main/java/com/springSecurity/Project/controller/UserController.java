package com.springSecurity.Project.controller;

import com.springSecurity.Project.entity.User;
import com.springSecurity.Project.repository.UserRepository;
import com.springSecurity.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


   @PutMapping()
   public ResponseEntity<?> updateUser(@RequestBody User user){
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String userName = authentication.getName();
       User userInDb =  userService.findByUsername(userName);
       userInDb.setUserName(user.getUserName());
       userInDb.setPassword(user.getPassword());
       userService.saveNewUser(userInDb);
       return new ResponseEntity<>(HttpStatus.OK);
   }

   @DeleteMapping
   public ResponseEntity<?> deleteById() {
       try {
           Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
           String userName = authentication.getName();
           userRepository.deleteByUserName(userName);
           return new ResponseEntity<>(HttpStatus.OK);
       } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
       }

   }
}