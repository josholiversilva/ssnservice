package com.josh.personal.SecretSantaService.entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Users")
public class User {
    @Id
    @Getter
    @Type(type = "uuid-char")
    private UUID uuid;
    @Getter
    @Setter
    @NotNull
    private String name;
    @Getter
    @Setter
    @NotNull
    private String email;
    @Getter
    @Setter
    @Builder.Default
    private int age = -1;
    @Getter
    @Setter
    @Builder.Default
    private float shoe_size = -1;
    @Getter
    @Setter
    private String shirt_size;
    @Getter
    @Setter
    private String pants_size;
    @Getter
    @Setter
    @Builder.Default
    private int ring_size = -1;
    @Getter
    @Setter
    private String picture_url;
}
