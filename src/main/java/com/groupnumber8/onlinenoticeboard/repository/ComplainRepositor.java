package com.groupnumber8.onlinenoticeboard.repository;

import com.groupnumber8.onlinenoticeboard.entities.Complains;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplainRepositor extends JpaRepository<Complains,Long> {
}
