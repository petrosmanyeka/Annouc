package com.groupnumber8.onlinenoticeboard.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @JsonIgnore
    private Long id;
    private String username;

    private String firstname;
    private String lastname;
    private String email;
   // @JsonIgnore
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Roles>roles;
}
