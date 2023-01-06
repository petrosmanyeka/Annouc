package com.groupnumber8.onlinenoticeboard.DTO;

import lombok.*;
import org.springframework.stereotype.Component;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AnnouncementDTO {

    private Long id;
    private String title;
    private String message;
    private String date;
    private String type;
}
