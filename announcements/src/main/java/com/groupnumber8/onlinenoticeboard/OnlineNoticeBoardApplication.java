package com.groupnumber8.onlinenoticeboard;

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@OpenAPIDefinition
@SpringBootApplication
public class OnlineNoticeBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineNoticeBoardApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

 }
