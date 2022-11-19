package com.josh.personal.SecretSantaService.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.*;
import java.security.Key;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name="Pairings")
public class Pairing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Setter
    private byte[] encryptedReceiverId;
    @NotNull
    @Setter
    private byte[] encryptedGiverId;
    @Getter
    @NotNull
    private LocalDate date;

    public Pairing(UUID receiverId, UUID giverId) {
        this.encryptedReceiverId = encryptId(receiverId.toString());
        this.encryptedGiverId = encryptId(giverId.toString());
        this.date = LocalDate.now();
    }

    public UUID getDecryptedReceiverId() {
        return UUID.fromString(decryptId(encryptedReceiverId));
    }

    public UUID getDecryptedGiverId() {
        return UUID.fromString(decryptId(encryptedGiverId));
    }

    private static byte[] encryptId(String user) {
        try {
            String key = "Wintermelon12345";
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(user.getBytes());
            return encrypted;
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return null;
    }

    private String decryptId(byte[] encryptedUser) {
        String decrypted = "-1";
        try {
            String key = "Wintermelon12345";
            Cipher cipher = Cipher.getInstance("AES");
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            decrypted = new String(cipher.doFinal(encryptedUser));
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return decrypted;
    }
}
