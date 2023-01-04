package com.groupnumber8.onlinenoticeboard.Exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnnouncementNotFoundException {
    private HttpStatus httpStatus;
    private String message;
    private Long timeStamp;
    private String path;
}
