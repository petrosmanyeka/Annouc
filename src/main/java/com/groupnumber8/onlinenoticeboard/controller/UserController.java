package com.groupnumber8.onlinenoticeboard.controller;

import com.groupnumber8.onlinenoticeboard.DTO.AppUserRoles;
import com.groupnumber8.onlinenoticeboard.DTO.UserDTO;
import com.groupnumber8.onlinenoticeboard.entities.AppUser;
import com.groupnumber8.onlinenoticeboard.entities.Roles;
import com.groupnumber8.onlinenoticeboard.service.UserService;
import com.groupnumber8.onlinenoticeboard.service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class UserController {
   @Autowired
    private UserService userService;
 @PostMapping("/savs")
   public String savaUser(@RequestBody UserDTO userDTO){
       return userService.saveUsers(userDTO);
   }
   @GetMapping("/alls")

    public List<AppUser> getAllUsers(){
     return userService.getAllUsers();
   }
   @GetMapping("/use/{username}")
    public String getUserName(@PathVariable String username){
     return userService.getUserName(username);
   }
   @PostMapping("/saverole")

    public String saeRole(@RequestBody Roles roles){
     return userService.saveRoles(roles);
   }
    @GetMapping("/use/{rolename}")
    public String getRoleName(@PathVariable String rolename){
        return userService.getRoleName(rolename);
    }
    @PostMapping
    public void  addRoleToUser(@RequestBody AppUserRoles appUserRoles){
     userService.addRolesToUser(appUserRoles.getUsername(),appUserRoles.getName());
    }
    @DeleteMapping("/delet/{id}")

    public String  deleteUser(@PathVariable("id") Long id){
     return userService.deleteuser(id);
    }



}
