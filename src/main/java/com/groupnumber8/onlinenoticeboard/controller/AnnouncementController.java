package com.groupnumber8.onlinenoticeboard.controller;

import com.groupnumber8.onlinenoticeboard.DTO.AnnouncementDTO;
import com.groupnumber8.onlinenoticeboard.entities.Announcement;
import com.groupnumber8.onlinenoticeboard.service.AnnouncementServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "announcement/api")
public class AnnouncementController {
    //Injecting Announcement Service Implementation Class

    @Autowired
    private AnnouncementServiceImplementation announcementServiceImplementation;


    @PostMapping(path = "/post")
    public String saveAnoucme(@RequestBody AnnouncementDTO announcementDTO){
        return  announcementServiceImplementation.saveAnoucement(announcementDTO);
    }
    @GetMapping(path = "/alla")
    public List<Announcement> getAllAnnouncements(){
        return announcementServiceImplementation.getAllAnnouc();

    }
    @GetMapping(path = "/public")
    public Optional<Announcement> getAllAnnouncementsPublic(){
        return announcementServiceImplementation.getAllPublic();

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
