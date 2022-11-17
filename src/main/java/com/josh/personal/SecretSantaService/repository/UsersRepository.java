package com.josh.personal.SecretSantaService.repository;

import com.josh.personal.SecretSantaService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {

}
