package com.josh.personal.SecretSantaService.api;

import com.josh.personal.SecretSantaService.dao.UsersDAO;
import com.josh.personal.SecretSantaService.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
