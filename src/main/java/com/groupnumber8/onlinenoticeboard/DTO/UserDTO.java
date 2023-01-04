package com.groupnumber8.onlinenoticeboard.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String username;

    private String firstname;
    private String lastname;
    private String email;

    private String password;

}
