package com.josh.personal.SecretSantaService.entities;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    private int age;
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
}
