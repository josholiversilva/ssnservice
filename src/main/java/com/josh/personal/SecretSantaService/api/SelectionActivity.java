package com.josh.personal.SecretSantaService.api;

import com.josh.personal.SecretSantaService.dao.PairingsDAO;
import com.josh.personal.SecretSantaService.dao.UsersDAO;
import com.josh.personal.SecretSantaService.helpers.EmailHelper;
import com.josh.personal.SecretSantaService.entities.Pairing;
import com.josh.personal.SecretSantaService.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SelectionActivity {
    @Autowired
    private EmailHelper emailHelper;
    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private PairingsDAO pairingsDAO;

    public void enact() {
        List<User> users = usersDAO.getAllUsers();
        List<Pairing> pairings = createPairings(users);
        for (Pairing pairing: pairings) {
            UUID giverId = pairing.getDecryptedGiverId();
            UUID receiverId = pairing.getDecryptedReceiverId();
            System.out.println(giverId);
            User giver = usersDAO.getUserByUuid(giverId);
            User receiver = usersDAO.getUserByUuid(receiverId);
            /*
            emailHelper.sendEmail("akingjosh101@gmail.com", //giver.getEmail(),
                    "Secret Santa Pairings!!",
                    getBody(receiver.getName()));
            pairingsDAO.postPairing(pairing);
             */
        }
    }

    private String getBody(String receiver) {
        return receiver + "\n\nanything on the list as long as it doesn't break your wallet :)"
                + "\nyay happy Christmas!" ;
    }

    private List<Pairing> createPairings(List<User> users) {
        List<Pairing> pairings = new ArrayList<>();
        Set<User> currentGivers = new HashSet<>();

        Collections.shuffle(users);
        for (int x=0; x<users.size(); x++) {
            Random rand = new Random();
            User receiver = users.get(x);
            User giver = users.get(rand.nextInt(users.size()));

            while (currentGivers.contains(giver) || giver == receiver) {
                giver = users.get(rand.nextInt(users.size()));
            }

            pairings.add(new Pairing(receiver.getUuid(), giver.getUuid()));
            currentGivers.add(giver);
        }

        return pairings;
    }
}
