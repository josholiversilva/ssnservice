package com.josh.personal.SecretSantaService.activities;

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
        List<User> users = usersDAO.getUsers();
        List<Pairing> pairings = createPairings(users);
        for (Pairing pairing: pairings) {
            /*
            emailHelper.sendEmail("akingjosh101@gmail.com",//pairing.getDecryptedGiverEmail(),
                    "Secret Santa Pairings!!",
                    getBody(pairing));
             */
            // System.out.println("Giver=" + pairing.getDecryptedGiverEmail() + ", Receiver=" + pairing.getDecryptedReceiver());
            // System.out.println("Encrypted receiver = " + pairing.getEncryptedReceiverId() +
                    // "Encrypted giver = " + pairing.getEncryptedGiverId());
            // PairingsDAO.createPairings(pairing);
/*
            usersDAO.createUser(User.builder()
                    .name("Josh Silva")
                    .email("akingjosh101@gmail.com")
                    .age(25)
                    .shoe_size((float)12.5)
                    .shirt_size("Large")
                    .pants_size("32x32")
                    .build());
 */
            pairingsDAO.createPairing(new Pairing(2,3));
            break;
        }
    }

    private String getBody(Pairing pairing) {
        String secretSantaFor = "<strong>" + pairing.getReceiverId() + "<strong>";
        return secretSantaFor + "\n\nanything on the list as long as it doesn't break your wallet :)"
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

            pairings.add(new Pairing(receiver.getId(), giver.getId()));
            currentGivers.add(giver);
        }

        return pairings;
    }
}
