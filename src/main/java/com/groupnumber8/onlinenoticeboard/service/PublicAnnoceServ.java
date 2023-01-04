package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.DTO.PublicAnnouceModels;
import com.groupnumber8.onlinenoticeboard.entities.PublicAnnouc;
import com.groupnumber8.onlinenoticeboard.repository.PublicAnnouceRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicAnnoceServ {

    @Autowired
    private PublicAnnouceRepos publicAnnouceRepos;

    public String savesPublicAnnou(PublicAnnouc publicAnnouc) {
        publicAnnouceRepos.save(publicAnnouc);
        return "saved";
    }

    public List<PublicAnnouc> getAll() {
        return publicAnnouceRepos.findAll();
    }
}
