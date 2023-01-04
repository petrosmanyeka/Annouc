package com.groupnumber8.onlinenoticeboard.controller;

import com.groupnumber8.onlinenoticeboard.DTO.AnnouncementDTO;
import com.groupnumber8.onlinenoticeboard.entities.Announcement;
import com.groupnumber8.onlinenoticeboard.repository.AnnouncementRepository;
import com.groupnumber8.onlinenoticeboard.service.AnnouncementService;
import com.groupnumber8.onlinenoticeboard.service.AnnouncementServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class AnnouncementController {
    @Autowired
    private AnnouncementRepository repository;
    //Injecting Announcement Service Implementation Class
    private final AnnouncementServiceImplementation announcementServiceImplementation;

    AnnouncementController(AnnouncementServiceImplementation announcementServiceImplementation){
        this.announcementServiceImplementation = announcementServiceImplementation;
    }
    @PostMapping
    public String saveAnn(@RequestBody Announcement announcement){
        repository.save(announcement);
        return "save";

    }
    @PostMapping(path = "/save")
    public ResponseEntity<AnnouncementDTO> newAnnouncement(@RequestBody AnnouncementDTO announcementDTO ){
        announcementServiceImplementation.postAnnouncement(announcementDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<AnnouncementDTO>> getAllAnnouncements(){
        return ResponseEntity.status(HttpStatus.OK).body(announcementServiceImplementation.fetchAllAnnouncements());
    }

    @GetMapping(path = "/mv/{id}")
    public Announcement getAnou(@PathVariable Long id){
        return repository.findById(id).get();
    }
@GetMapping
    public ResponseEntity<AnnouncementDTO> getByName(@PathVariable("id") Long id){
        var fetchedAnnouncementDTO = announcementServiceImplementation.fetchAnnouncementById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(fetchedAnnouncementDTO);
}
@DeleteMapping(path = "/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        return announcementServiceImplementation.deleteAnnouncement(id);
}

@PutMapping("/put/{id}")

    public String updates(@RequestBody AnnouncementDTO announcementDTO ,@PathVariable("id") Long id){
        return announcementServiceImplementation.updatesANou(announcementDTO,id);
}

}
