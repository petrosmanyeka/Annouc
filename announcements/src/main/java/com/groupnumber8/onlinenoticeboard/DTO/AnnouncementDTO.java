package com.groupnumber8.onlinenoticeboard.DTO;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AnnouncementDTO {
    private Long id;
    private String title;
    private String message;
    private String postedOn;
    private String expireOn;
}
