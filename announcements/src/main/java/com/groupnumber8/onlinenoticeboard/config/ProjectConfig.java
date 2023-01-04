package com.groupnumber8.onlinenoticeboard.config;

import com.groupnumber8.onlinenoticeboard.service.UserServiceImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserServiceImplementation userServiceImplementation;

    public ProjectConfig(PasswordEncoder passwordEncoder, UserServiceImplementation userServiceImplementation ) {
        this.passwordEncoder = passwordEncoder;
        this.userServiceImplementation = userServiceImplementation;

    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(this.userServiceImplementation);
        return authenticationProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
         auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http
                 .cors()
                 .and()
                 .csrf()
                 .disable()
                 .authorizeRequests().anyRequest().permitAll()
//                 .antMatchers("/hello").hasAnyAuthority("STUDENT","ADMIN")
//                 .mvcMatchers("/users").hasAnyAuthority("ADMIN")
//                 .mvcMatchers("/logged").hasAnyAuthority(" ADMIN")
//                 .mvcMatchers("/register").hasAnyAuthority("STUDENT","ADMIN")
//                 .mvcMatchers("/user/{username}").hasAuthority("ADMIN")
//                // .mvcMatchers(HttpMethod.DELETE,"/terminate/{username}").hasAuthority("ADMIN")
//                 .antMatchers(HttpMethod.POST,"/post").permitAll()
//                 .antMatchers(HttpMethod.GET,"/all").authenticated()
                 .and()
                 .httpBasic();
    }
}