package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.DTO.AnnouncementDTO;
import com.groupnumber8.onlinenoticeboard.entities.Announcement;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AnnouncementService {





    ResponseEntity<AnnouncementDTO> postAnnouncement(AnnouncementDTO announcementDTO);

    AnnouncementDTO fetchAnnouncementById(Long id);

    String enquireAnnouncementInfo();

    List<AnnouncementDTO> fetchAllAnnouncements();


    String deleteAnnouncement(Long id);
}
