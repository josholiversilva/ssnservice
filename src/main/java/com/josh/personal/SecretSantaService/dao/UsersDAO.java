package com.josh.personal.SecretSantaService.dao;

import com.josh.personal.SecretSantaService.entities.User;
import com.josh.personal.SecretSantaService.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersDAO {
    @Autowired
    private UsersRepository repository;

    public User postUser(User user) {
        return repository.save(user);
    }

    public List<User> postUsers(List<User> users) {
        return repository.saveAll(users);
    }

    public User getUserByUuid(UUID uuid){
        if (repository.findByUuid(uuid.toString()).size() == 0) {
            return null;
        }
        return repository.findByUuid(uuid.toString()).get(0);
    }

    public User getUserByEmail(String email) {
        if (repository.findByEmail(email).size() == 0) {
            return null;
        }

        return repository.findByEmail(email).get(0);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
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
            users.add(User.builder().uuid(UUID.randomUUID()).email(email).name(name).build());
        }

        return users;
    }
}
