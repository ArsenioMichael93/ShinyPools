package com.example.shinypools.database.dao;

import com.example.shinypools.database.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicesDAO extends JpaRepository<Services, Long> {

    public Services findById(@Param("id") Integer id);

    public Services findServicesByName(@Param("name") String name);

    public Services findServicesByDescription(@Param("description") String description);


}
