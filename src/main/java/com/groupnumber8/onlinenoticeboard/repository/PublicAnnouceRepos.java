package com.groupnumber8.onlinenoticeboard.repository;

import com.groupnumber8.onlinenoticeboard.DTO.PublicAnnouceModels;
import com.groupnumber8.onlinenoticeboard.entities.PublicAnnouc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicAnnouceRepos extends JpaRepository<PublicAnnouc,Long> {
}
