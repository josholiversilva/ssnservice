package com.josh.personal.SecretSantaService.repository;

import com.josh.personal.SecretSantaService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM Users WHERE uuid=?1", nativeQuery = true)
    List<User> findByUuid(String uuid);

    @Query(value = "SELECT * FROM Users WHERE email=?1", nativeQuery = true)
    List<User> findByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Users SET picture_url=?1 WHERE uuid=?2", nativeQuery = true)
    void updateUserPic(String picture_url, String uuid);
}
