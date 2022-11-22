package com.josh.personal.SecretSantaService.dao;

import com.josh.personal.SecretSantaService.entities.Wishlist;
import com.josh.personal.SecretSantaService.repository.WishlistRepository;
import com.josh.personal.SecretSantaService.requests.WishlistRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WishlistDAO {
    @Autowired
    WishlistRepository repository;

    public List<Wishlist> getWishlistsForUserId(String uuid, Integer year) {
        List<Wishlist> items = repository.findAllByUuidAndYear(uuid, year);
        if (CollectionUtils.isEmpty(items)) {
            return null;
        }
        return items;
    }

    public Wishlist postWishlistForUserId(String uuid, Wishlist wishlist) {
        repository.postByUuid(uuid, wishlist.getItem(), wishlist.getPrice(), wishlist.getDescription(), wishlist.getYear());
        return wishlist;
    }

    public Wishlist deleteWishlistForUserId(WishlistRequest wishlistRequest) throws Exception {
        Optional<Wishlist> toDelete = repository.findById(wishlistRequest.getId());
        if (toDelete.isPresent()) {
            repository.delete(toDelete.orElseThrow(Exception::new));
        }
        return toDelete.orElseThrow(Exception::new);
    }
}
