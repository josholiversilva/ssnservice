package com.josh.personal.SecretSantaService.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.*;
import java.security.Key;

@Data
@Entity
@Table(name="Pairings")
public class Pairing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Getter
    @ManyToOne(targetEntity = User.class,
            fetch= FetchType.EAGER,
            cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "receiverId", referencedColumnName = "id")
    @NotNull
    private Integer receiverId;
    @Getter
    @ManyToOne(targetEntity = User.class,
            fetch= FetchType.EAGER,
            cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "giverId", referencedColumnName = "id")
    @NotNull
    private Integer giverId;

    public Pairing(Integer receiverId, Integer giverId) {
        this.receiverId = receiverId;
        this.giverId = giverId;
    }

    public byte[] getEncryptedReceiverId() {
        return encryptUser(this.receiverId.toString());
    }
    public byte[] getEncryptedGiverId() {
        return encryptUser(this.giverId.toString());
    }

    private static byte[] encryptUser(String user) {
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

    private String decryptUser(byte[] encryptedUser) {
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
