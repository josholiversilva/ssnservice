package com.josh.personal.SecretSantaService.dao;

import com.josh.personal.SecretSantaService.entities.User;
import com.josh.personal.SecretSantaService.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersDAO {
    @Autowired
    private UsersRepository repository;

    public User createUser(User user) {
        return repository.save(user);
    }

    public List<User> getUsers() {
        Map<String, String> userEmails = new HashMap<>();
        userEmails.put("agbayaniana@gmail.com", "Ana Agbayani");
        userEmails.put("brianwi007@gmail.com", "Brian Wi");
        userEmails.put("ngynbryan@gmail.com", "Bryan Nguyen");
        userEmails.put("vincentho0129@gmail.com", "Vincent Ho");
        userEmails.put("ryanjamesaquino@gmail.com", "Ryan Aquino");
        userEmails.put("meli26salamat@gmail.com", "Melissa Salamat");
        userEmails.put("irisyee8@gmail.com", "Iris Yee");
        userEmails.put("akingjosh101@gmail.com", "Josh Silva");
        userEmails.put("Ericliu2244@gmail.com", "Eric Liu");
        userEmails.put("shawnbnat@gmail.com", "Shawn Feng");
        userEmails.put("victoriatrnn@gmail.com", "Victoria Tran");

        List<User> users = new ArrayList<>();
        for (Map.Entry<String, String> entry: userEmails.entrySet()) {
            String email = entry.getKey();
            String name = entry.getValue();
            users.add(User.builder().email(email).name(name).build());
        }

        return users;
    }
}
