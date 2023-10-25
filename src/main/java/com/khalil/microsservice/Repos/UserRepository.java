package com.khalil.microsservice.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.khalil.microsservice.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query("select u from User u where u.user_id = ?1")
    User findUserById(Long id);



    @Modifying
    @Query("DELETE FROM User u WHERE u.user_id = :userId")
    void deleteByUserId(@Param("userId") Long userId);


    @Query("select u.code from User u where u.username = ?1")
    String getCodeByUsername(String username);




}