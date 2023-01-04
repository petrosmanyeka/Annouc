package com.groupnumber8.onlinenoticeboard.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicAnnouceModels {
    private String title;
    private String message;
    private String postedOn;
    private String expireOn;
}
