package com.groupnumber8.onlinenoticeboard.repository;
import com.groupnumber8.onlinenoticeboard.entities.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    List<Announcement> findAll();


}
