package com.groupnumber8.onlinenoticeboard.controller;

import com.groupnumber8.onlinenoticeboard.DTO.LogIn;
import com.groupnumber8.onlinenoticeboard.repository.UserRepository;
import com.groupnumber8.onlinenoticeboard.service.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class LogInControl {

    @Autowired
    private AuthenticationManager authenticationManager;


   
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @PostMapping("/log")
    public JsonTokenResponse checkDetails(@RequestBody LogIn logIn){
        JwtClassToken jwtClassToken =new JwtClassToken();
      
        try {
            Authentication  authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    logIn.getUsername(), logIn.getPassword()
            ));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch ( BadCredentialsException e){
            throw new RuntimeException("Bad request");

        }
        final UserDetails userDetails =userServiceImplementation.loadUserByUsername(logIn.getUsername());

        final String token = jwtClassToken.generateJwtToken(userDetails);
        return new JsonTokenResponse(token);
    }
}
