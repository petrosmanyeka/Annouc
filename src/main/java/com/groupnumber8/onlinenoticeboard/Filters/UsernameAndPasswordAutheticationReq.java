package com.groupnumber8.onlinenoticeboard.Filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsernameAndPasswordAutheticationReq {
    private String username;
    private String password;
}
