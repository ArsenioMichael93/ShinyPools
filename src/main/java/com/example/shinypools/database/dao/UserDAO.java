package com.example.shinypools.database.dao;

import com.example.shinypools.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    public User findById(@Param("id") Integer id);

    // native query
    @Query(value = "select * from users where email = :email", nativeQuery = true)

    // this is a JPA Query is a hibernate JLQ or HQL query


    public User findByEmail(@Param("email") String email);

    public List<User> findByFirstNameIgnoreCaseContaining(@Param("firstName") String firstName);

    public List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("select u from User u where u.firstName = ?1")
    public User findByFirstName(@Param("firstName") String firstName);


}
