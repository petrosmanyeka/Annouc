package com.groupnumber8.onlinenoticeboard.Filters;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@ComponentScan

public class CustomeUserNameAndPass extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    public CustomeUserNameAndPass(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
      try {
          UsernameAndPasswordAutheticationReq autheticationReq = new ObjectMapper().readValue(
                  request.getInputStream(), UsernameAndPasswordAutheticationReq.class
          );
          Authentication authentication = new UsernamePasswordAuthenticationToken(
                  autheticationReq.getUsername(),autheticationReq.getPassword()
          );
          return authenticationManager.authenticate(authentication);
      }catch (IOException e){
          throw new RuntimeException(e);
      }
    }

}
