package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.DTO.AnnouncementDTO;
import com.groupnumber8.onlinenoticeboard.entities.Announcement;
import com.groupnumber8.onlinenoticeboard.repository.AnnouncementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AnnouncementServiceImplementation implements AnnouncementService{
    private final AnnouncementRepository announcementRepository;
    AnnouncementServiceImplementation(AnnouncementRepository announcementRepository ){
        this.announcementRepository = announcementRepository;
    }
    @Override
    public ResponseEntity<AnnouncementDTO> postAnnouncement(AnnouncementDTO announcementDTO) {
        //Check For NoNull Object
       // if (!announcementDTO.getName().isBlank()&&announcementDTO.getMessage().isEmpty()&&announcementDTO.getPostedOn().after(announcementDTO.getExpireOn())) {
            //Mapping DTO to Entity
            Announcement announcement = new Announcement();
            announcement.setTitle( announcementDTO.getTitle());
            announcement.setMessage(announcementDTO.getMessage() );
            announcement.setPostedOn( announcementDTO.getPostedOn());
            announcement.setExpireOn(announcementDTO.getExpireOn() );
            //Now Save The Entity to DB
            announcementRepository.save(announcement);
            return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @Override
    public AnnouncementDTO fetchAnnouncementById(Long id) {
        //MAKE IT CARE INSENSITIVE
       Announcement announcement = announcementRepository.findById(id).get();
       if (announcement.getId().equals(id)){
           //Converting to DTO
           var announcementDTO = new AnnouncementDTO();

           announcementDTO.setTitle(announcement.getTitle());
           announcementDTO.setMessage(announcement.getMessage());
           announcementDTO.setPostedOn(announcement.getPostedOn());
           announcementDTO.setExpireOn(announcement.getExpireOn());
           //Return this
           return announcementDTO;
       }else {
           return null;
       }
    }
    @Override
    public String enquireAnnouncementInfo() {
        return null;
    }
    @Override
    public List<AnnouncementDTO> fetchAllAnnouncements() {
        List<Announcement> announcementList = announcementRepository.findAll();
        List<AnnouncementDTO> announcementDTOList = new ArrayList<>();
        for (Announcement announcement: announcementList) {
            AnnouncementDTO myAnnouncementDTO = new AnnouncementDTO();
            myAnnouncementDTO.setId(announcement.getId());
            myAnnouncementDTO.setTitle(announcement.getTitle());
            myAnnouncementDTO.setMessage(announcement.getMessage());
            myAnnouncementDTO.setPostedOn(announcement.getPostedOn());
            myAnnouncementDTO.setExpireOn(announcement.getExpireOn());
            //Add Every DTO to DTO list
            announcementDTOList.add(myAnnouncementDTO);
        }
        return announcementDTOList ;
    }

    @Override
    public String deleteAnnouncement(Long id) {

        announcementRepository.deleteById(id);
        return "Deleted Announcement " ;
    }

    public String updatesANou(AnnouncementDTO announcementDTO, Long id) {
        Announcement announcement = announcementRepository.findById(id).get();
        if(Objects.nonNull(announcementDTO.getPostedOn()) && !"".equalsIgnoreCase(announcementDTO.getPostedOn())){
            announcement.setPostedOn(announcementDTO.getPostedOn());
        }
        if(Objects.nonNull(announcementDTO.getExpireOn()) && !"".equalsIgnoreCase(announcementDTO.getExpireOn())){
            announcement.setExpireOn(announcementDTO.getExpireOn());
        }
        if(Objects.nonNull(announcementDTO.getTitle())&& !"".equalsIgnoreCase(announcementDTO.getTitle())){
            announcement.setTitle(announcementDTO.getTitle());
        }
        if(Objects.nonNull(announcementDTO.getMessage()) && !"".equalsIgnoreCase(announcementDTO.getMessage())){
            announcement.setMessage(announcementDTO.getMessage());
        }
        return "updated";
    }
}
