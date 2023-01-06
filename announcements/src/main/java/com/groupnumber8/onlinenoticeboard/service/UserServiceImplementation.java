package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.DTO.UserDTO;
import com.groupnumber8.onlinenoticeboard.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements  UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImplementation(PasswordEncoder passwordEncoder, UserRepository userRepository ) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByUsername(username);
        SecurityUser securityUser = new SecurityUser(user);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
            return securityUser;
    }
    @Override
    public void registerNewUser(UserDTO userDTO) {
         User user = new User();
         user.setEmail(userDTO.getEmail());
         user.setFirstName(userDTO.getFirstName());
         user.setLastName(userDTO.getLastName());
         user.setRegNumber(userDTO.getRegNumber());
         user.setUsername(userDTO.getUsername());
         user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
         user.setRole(userDTO.getRole());
        userRepository.save(user);
    }
    @Override
    public List<User> allSystemUsers() {
        //TODO: Map each user in the list to DTO & Convert each DTO to a LIst ==> Return this List of DTOs
        return userRepository.findAll();
    }



    @Override
    public void updateUserDetails(String username, UserDTO userDTO) {
    }


    public String delete(Long id) {
        userRepository.deleteById(id);
        return "deleted";
    }


    public Optional<User> findUsers(Long id) {
        return userRepository.findById(id);
    }
}
