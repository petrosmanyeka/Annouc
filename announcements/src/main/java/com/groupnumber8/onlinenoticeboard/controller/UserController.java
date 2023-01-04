package com.groupnumber8.onlinenoticeboard.controller;

import com.groupnumber8.onlinenoticeboard.DTO.UserDTO;
import com.groupnumber8.onlinenoticeboard.entities.User;
import com.groupnumber8.onlinenoticeboard.service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class UserController {
     @Autowired
    private UserServiceImplementation userServiceImplementation;

    @GetMapping("/hello")
    public String hello(){
         return "Hello";
     }

     @PostMapping("/register")
     public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO){
          userServiceImplementation.registerNewUser(userDTO);
          return ResponseEntity.status(HttpStatus.CREATED).build();
     }
     @GetMapping("/logged")
    public String loggenInUser( ){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        // String password = authentication.getCredentials().toString();
         System.out.println(username);
         String details = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getDetails());
         System.out.println(details);
        return "loggedUser is " + username + " \nand password is \n" ;
     }
     @GetMapping("/user/{id}")
      public Optional<User> findUser(@PathVariable("id") Long id){
        return userServiceImplementation.findUsers(id);
     }
     @GetMapping("/use")
    public List<User> getAll(){
        return  userServiceImplementation.allSystemUsers();
     }
     @DeleteMapping("/del/{id}")
    public String deleteUserFromDB(@PathVariable("id") Long id){
        return userServiceImplementation.delete(id);

     }


}
