package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.DTO.UserDTO;
import com.groupnumber8.onlinenoticeboard.entities.AppUser;
import com.groupnumber8.onlinenoticeboard.entities.Roles;
import com.groupnumber8.onlinenoticeboard.repository.RolesRepository;
import com.groupnumber8.onlinenoticeboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements  UserService , UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesRepository rolesRepository;


    @Override
    public String saveUsers(UserDTO userDTO) {
        AppUser appUser = new AppUser();
        appUser.setUsername(userDTO.getUsername());
        appUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        appUser.setFirstname(userDTO.getFirstname());

        appUser.setEmail(userDTO.getEmail());
        appUser.setLastname(userDTO.getLastname());


        userRepository.save(appUser);

        return "saved";
    }

    @Override
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public AppUser getUserName(String username) {
       return userRepository.findByUsername(username);

    }

    @Override
    public String saveRoles(Roles roles) {
        rolesRepository.save(roles);
        return "Roles saved";
    }

    @Override
    public String getRoleName(String name) {
        rolesRepository.findByName(name);
        return "getted";
    }

    @Override
    public void addRolesToUser(String username, String name) {
        AppUser appUser = userRepository.findByUsername(username);
        Roles roles = rolesRepository.findByName(name);
        appUser.getRoles().add(roles);
        userRepository.save(appUser);
    }

    @Override
    public String deleteuser(Long id) {
        userRepository.deleteById(id);
        return "deleted";
    }

    @Override
    public String getUserId(Long id) {
        userRepository.findById(id);

        return "user";
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByUsername(username);
        Collection<SimpleGrantedAuthority>authorities = new ArrayList<>();
        appUser.getRoles().forEach(roles -> {
            authorities.add(new SimpleGrantedAuthority(roles.getName()));
        });
        return new User(appUser.getUsername(),appUser.getPassword(),authorities);
    }
}
