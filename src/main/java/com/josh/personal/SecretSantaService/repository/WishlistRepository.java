package com.josh.personal.SecretSantaService.repository;

import com.josh.personal.SecretSantaService.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    @Query(value = "SELECT * FROM Wishlist WHERE user_id=?1 AND year=?2", nativeQuery = true)
    List<Wishlist> findAllByUuidAndYear(String uuid, Integer year);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Wishlist (user_id, item, price, description, year) VALUES (?1,?2,?3,?4,?5)", nativeQuery = true)
    void postByUuid(String uuid, String item, String price, String description, Integer year);
}
