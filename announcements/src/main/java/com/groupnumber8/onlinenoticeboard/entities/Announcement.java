package com.groupnumber8.onlinenoticeboard.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String message;
    private String postedOn;
    private String expireOn;
}
