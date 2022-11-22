package com.josh.personal.SecretSantaService.api;

import com.josh.personal.SecretSantaService.dao.WishlistDAO;
import com.josh.personal.SecretSantaService.entities.User;
import com.josh.personal.SecretSantaService.entities.Wishlist;
import com.josh.personal.SecretSantaService.requests.WishlistRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/wishlist")
@RestController
public class WishlistActivity {
    @Autowired
    WishlistDAO wishlistDAO;

    public void enact() {
        // Get User
        // Get Wishlist fields
        // Check wishlist empty
        // if empty - create wishlist for year
        // else     - update wishlist for year
        // return wishlist
    }

    @CrossOrigin
    @GetMapping(path = {"{user_id}/{year}"})
    public List<Wishlist> getWishlistForUserId(@PathVariable("user_id") String userId,
                                               @PathVariable("year") Integer year) {
        System.out.println("uuid = " + userId + " & year = " + year);
        return wishlistDAO.getWishlistsForUserId(userId, year);
    }

    @CrossOrigin
    @PostMapping(path={"{user_id}"})
    public Wishlist postWishlistForUserId(@PathVariable("user_id") String userId,
                                          @RequestBody Wishlist wishlist) {
        System.out.println("uuid = " + userId);
        return wishlistDAO.postWishlistForUserId(userId, wishlist);
    }

    @CrossOrigin
    @DeleteMapping
    public Wishlist deleteItemForUserId(@RequestBody WishlistRequest wishlistRequest) {
        try {
            return wishlistDAO.deleteWishlistForUserId(wishlistRequest);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
