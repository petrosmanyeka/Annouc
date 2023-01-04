package com.groupnumber8.onlinenoticeboard.repository;

import com.groupnumber8.onlinenoticeboard.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,Long> {
    Roles findByName(String name);
}
