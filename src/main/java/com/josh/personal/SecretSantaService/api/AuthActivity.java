package com.josh.personal.SecretSantaService.api;

import com.josh.personal.SecretSantaService.dao.UsersDAO;
import com.josh.personal.SecretSantaService.entities.User;
import com.josh.personal.SecretSantaService.helpers.GoogleAuthHelper;
import com.josh.personal.SecretSantaService.requests.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/google-auth")
@RestController
public class AuthActivity {
    @Autowired
    UsersDAO usersDAO;

    @CrossOrigin
    @PostMapping(consumes = {"application/json"})
    public User getUserInfo(@RequestBody AuthRequest authRequest) {
        System.out.println("Activated!");
        GoogleAuthHelper googleAuthHelper = new GoogleAuthHelper();

        String email = googleAuthHelper.getEmail(authRequest.getIdToken());
        User user = usersDAO.getUserByEmail(email);
        if (user != null && user.getPicture_url() == null) {
            String pictureUrl = googleAuthHelper.getPictureUrl(authRequest.getIdToken());
            usersDAO.updateUserPic(user, pictureUrl);
            user.setPicture_url(pictureUrl);
        }
        return user;
    }
}
