package com.josh.personal.SecretSantaService.repository;

import com.josh.personal.SecretSantaService.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    @Query(value = "SELECT * FROM Wishlist WHERE user_id=?1", nativeQuery = true)
    List<Wishlist> findAllByUuid(String uuid);
}
