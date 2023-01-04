package com.groupnumber8.onlinenoticeboard.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PublicAnnouc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titl;
    private String messages;
    private String postedon;
    private String expireon;
}
