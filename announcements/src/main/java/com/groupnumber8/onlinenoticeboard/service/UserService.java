package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.DTO.UserDTO;
import com.groupnumber8.onlinenoticeboard.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void registerNewUser(UserDTO userDTOr);
    List<User> allSystemUsers();

    void updateUserDetails(String username, UserDTO userDTO);


}
