package com.groupnumber8.onlinenoticeboard.controller;

import com.groupnumber8.onlinenoticeboard.DTO.AnnouncementDTO;
import com.groupnumber8.onlinenoticeboard.entities.Announcement;
import com.groupnumber8.onlinenoticeboard.service.AnnouncementServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class AnnouncementController {
    //Injecting Announcement Service Implementation Class

    @Autowired
    private AnnouncementServiceImplementation announcementServiceImplementation;


    @PostMapping(path = "/pos")
    public String saveAnoucme(@RequestBody AnnouncementDTO announcementDTO){
        return  announcementServiceImplementation.saveAnoucement(announcementDTO);
    }
    @GetMapping(path = "/all")
    public List<Announcement> getAllAnnouncements(){
        return announcementServiceImplementation.getAllAnnouc();

    }
@GetMapping(path = "/mvc/{id}")
    public String getAnn(@PathVariable("id") Long id){
     return announcementServiceImplementation.getSingleAnnoucemennt(id);
}

@DeleteMapping(path = "/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        return announcementServiceImplementation.deleteAnnouncement(id);
}

}
