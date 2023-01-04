package com.groupnumber8.onlinenoticeboard.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "mapoto")
public class User {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   // @JsonIgnore
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String regNumber;
   // @JsonIgnore
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
