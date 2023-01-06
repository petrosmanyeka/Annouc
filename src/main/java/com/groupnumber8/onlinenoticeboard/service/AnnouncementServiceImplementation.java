package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.DTO.AnnouncementDTO;
import com.groupnumber8.onlinenoticeboard.entities.Announcement;
import com.groupnumber8.onlinenoticeboard.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementServiceImplementation implements AnnouncementService{
    private final AnnouncementRepository announcementRepository;
    private  final  AnnouncementDTO announcementDTO;
    AnnouncementServiceImplementation(AnnouncementRepository announcementRepository, AnnouncementDTO announcementDTO){
        this.announcementRepository = announcementRepository;
        this.announcementDTO = announcementDTO;
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
        announcement.setDate( announcementDTO.getDate());
        announcement.setType(announcementDTO.getType() );
        //Now Save The Entity to DB
        announcementRepository.save(announcement);

        return "save";
    }

    public Optional<Announcement> getAllPublic() {
        return announcementRepository.findAnnouncementByType(announcementDTO.getType());
    }
}
