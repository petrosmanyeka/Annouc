package com.groupnumber8.onlinenoticeboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class ProjectConfig  {


@Autowired
    private UserDetailsService userDetailsService;


@Autowired
private PasswordEncoder passwordEncoder;

   @Bean
   public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
       return authConfiguration.getAuthenticationManager();
   }



    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(userDetailsService);

        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity

                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests().anyRequest().permitAll();
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //httpSecurity.addFilter(new CustomeUserNameAndPass(authenticationManager(new AuthenticationConfiguration())));

        httpSecurity.authenticationProvider(daoAuthenticationProvider());
//                .antMatchers("/hello").hasAnyAuthority("STUDENT","ADMIN")
//                .mvcMatchers("/users").hasAnyAuthority("ADMIN")
//                .mvcMatchers("/logged").hasAnyAuthority(" ADMIN")
//                .mvcMatchers("/register").hasAnyAuthority("STUDENT","ADMIN")
//                .mvcMatchers("/user/{username}").hasAuthority("ADMIN")
//                // .mvcMatchers(HttpMethod.DELETE,"/terminate/{username}").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.POST,"/post").permitAll()
//                .antMatchers(HttpMethod.GET,"/all").authenticated()
//                .and()
//                .httpBasic();

        return  httpSecurity.build();
    }


}