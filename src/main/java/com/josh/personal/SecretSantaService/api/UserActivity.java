package com.josh.personal.SecretSantaService.api;

import com.josh.personal.SecretSantaService.dao.UsersDAO;
import com.josh.personal.SecretSantaService.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/user")
@RestController
public class UserActivity {
    @Autowired
    UsersDAO usersDAO;

    @CrossOrigin
    @GetMapping
    public List<User> getUsers() {
        return usersDAO.getAllUsers();
    }

    @CrossOrigin
    @GetMapping(path={"{uuid}"})
    public User getUser(@PathVariable("uuid") UUID uuid) {
        return usersDAO.getUserByUuid(uuid);
    }
}
