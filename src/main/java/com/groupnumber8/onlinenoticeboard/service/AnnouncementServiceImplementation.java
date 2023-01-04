package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.DTO.AnnouncementDTO;
import com.groupnumber8.onlinenoticeboard.DTO.PublicAnnouceModels;
import com.groupnumber8.onlinenoticeboard.entities.Announcement;
import com.groupnumber8.onlinenoticeboard.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImplementation implements AnnouncementService{
    private final AnnouncementRepository announcementRepository;
    AnnouncementServiceImplementation(AnnouncementRepository announcementRepository ){
        this.announcementRepository = announcementRepository;
    }


    @Autowired




    public List<Announcement> getAllAnnouc() {
        return announcementRepository.findAll();
    }

    public String getSingleAnnoucemennt(Long id) {
        announcementRepository.findById(id);
        return "Annouceme is geted";
    }

    public String deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id);
        return "successfully deleted";
    }

    public String saveAnoucement(AnnouncementDTO announcementDTO) {
        Announcement announcement = new Announcement();

        announcement.setTitle( announcementDTO.getTitle());
        announcement.setMessage(announcementDTO.getMessage() );
        announcement.setPostedOn( announcementDTO.getPostedOn());
        announcement.setExpireOn(announcementDTO.getExpireOn() );
        //Now Save The Entity to DB
        announcementRepository.save(announcement);

        return "save";
    }
}
