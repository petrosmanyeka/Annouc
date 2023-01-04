package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.DTO.UserDTO;
import com.groupnumber8.onlinenoticeboard.entities.AppUser;
import com.groupnumber8.onlinenoticeboard.entities.Roles;


import java.util.List;

public interface UserService  {


    String saveUsers(UserDTO userDTO);

    List<AppUser> getAllUsers();

    String getUserName(String username);

    String saveRoles(Roles roles);

    String getRoleName(String name);


    void addRolesToUser(String username, String name);

    String deleteuser(Long id);
}
