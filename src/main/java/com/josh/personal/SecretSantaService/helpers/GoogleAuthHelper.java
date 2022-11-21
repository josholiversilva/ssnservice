package com.josh.personal.SecretSantaService.helpers;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.josh.personal.SecretSantaService.dao.UsersDAO;
import com.josh.personal.SecretSantaService.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class GoogleAuthHelper {
    @Autowired
    UsersDAO usersDAO;

    private static GoogleIdTokenVerifier verifier;
    public GoogleAuthHelper() {
        verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                .setAudience(Collections.singletonList("586874960556-gi3i91godpvj7ulnl14km0d3vgpno44m.apps.googleusercontent.com"))
                .build();
    }

    public String getEmail(String idTokenString) {
        try {
            GoogleIdToken idToken = verifier.verify(idTokenString);
            GoogleIdToken.Payload payload = idToken.getPayload();
            String userId = payload.getSubject();
            String name = (String) payload.get("name");
            String email = payload.getEmail();
            String pictureUrl = (String) payload.get("picture");

            return email;
        } catch (GeneralSecurityException gse) {
            System.out.println("General Security Exception - " + gse);
        } catch (IOException io) {
            System.out.println("IO Exception - " + io);
        } catch (Exception e) {
            System.out.println("Error occurred = " + e);
        }
        return null;
    }
}
