package com.groupnumber8.onlinenoticeboard.controller;

import com.groupnumber8.onlinenoticeboard.DTO.AppUserRoles;
import com.groupnumber8.onlinenoticeboard.DTO.UserDTO;
import com.groupnumber8.onlinenoticeboard.entities.AppUser;
import com.groupnumber8.onlinenoticeboard.entities.Roles;
import com.groupnumber8.onlinenoticeboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping(path = "user/api")
public class UserController {
   @Autowired
    private UserService userService;
 @PostMapping("/register")
   public String savaUser(@RequestBody UserDTO userDTO){
       return userService.saveUsers(userDTO);
   }

   @GetMapping("/user/{id}")

   public  String getUserId(@PathVariable Long id){
     return userService.getUserId(id);
   }
    @GetMapping("/alls")
    public List<AppUser> getAllUsers(){
     return userService.getAllUsers();
   }
   @GetMapping("/{username}")
    public AppUser getUserName(@PathVariable String username){
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
