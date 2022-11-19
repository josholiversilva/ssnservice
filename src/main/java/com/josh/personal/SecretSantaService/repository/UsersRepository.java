package com.josh.personal.SecretSantaService.repository;

import com.josh.personal.SecretSantaService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM Users WHERE uuid=?1", nativeQuery = true)
    List<User> findByUuid(String uuid);
}
