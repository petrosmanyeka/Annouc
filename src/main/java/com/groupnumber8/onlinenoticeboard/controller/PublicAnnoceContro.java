package com.groupnumber8.onlinenoticeboard.controller;

import com.groupnumber8.onlinenoticeboard.DTO.PublicAnnouceModels;
import com.groupnumber8.onlinenoticeboard.entities.PublicAnnouc;
import com.groupnumber8.onlinenoticeboard.service.AnnouncementService;
import com.groupnumber8.onlinenoticeboard.service.PublicAnnoceServ;
import com.groupnumber8.onlinenoticeboard.service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class PublicAnnoceContro {

    @Autowired
    private PublicAnnoceServ publicAnnoceServ;


    @PostMapping("/pub")

    public String savePublicAnnou(@RequestBody PublicAnnouc publicAnnouc){
        return publicAnnoceServ. savesPublicAnnou(publicAnnouc);
    }
    @GetMapping("/gets")
    public List<PublicAnnouc> getAllAno(){
        return publicAnnoceServ.getAll();
    }
}
