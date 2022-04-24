package com.example.shinypools.database.dao;

import com.example.shinypools.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.shinypools.database.entity.UserRole;

import java.util.List;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(@Param("userId") Integer userId);

    public UserRole findByUserRole(@Param("id") Integer id);
}

