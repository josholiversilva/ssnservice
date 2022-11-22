package com.josh.personal.SecretSantaService.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name="Wishlist")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="user_id")
    @NotNull
    @Setter
    private User user;
    @Getter
    @Setter
    @NotNull
    private Integer year;
    @NotNull
    @Getter
    @Setter
    private String item;
    @Getter
    @Setter
    @NotNull
    private String price;
    @NotNull
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String url;
    @Getter
    @Setter
    private String item_type;
    @Getter
    @Setter
    private String size;
    @Getter
    @Setter
    private String color;
}
