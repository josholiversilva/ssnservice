package com.josh.personal.SecretSantaService.dao;

import com.josh.personal.SecretSantaService.entities.Wishlist;
import com.josh.personal.SecretSantaService.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@Service
public class WishlistDAO {
    @Autowired
    WishlistRepository repository;

    public List<Wishlist> getWishlistsForUserId(String uuid) {
        List<Wishlist> items = repository.findAllByUuid(uuid);
        System.out.println("items = " + items + " for uuid = " + uuid);
        if (CollectionUtils.isEmpty(items)) {
            System.out.println("items = " + items + " for uuid = " + uuid);
            return null;
        }
        System.out.println("items = " + items + " for uuid = " + uuid);
        return items;
    }
}
