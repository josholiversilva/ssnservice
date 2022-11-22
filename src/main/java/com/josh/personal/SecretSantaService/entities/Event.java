package com.josh.personal.SecretSantaService.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Getter
    @Setter
    @NotNull
    private Integer year;
    @Getter
    @Setter
    @NotNull
    private String address;
    @Getter
    @Setter
    @NotNull
    private String date;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String theme;
    @Getter
    @Setter
    private String price_limit;
    @Getter
    @Setter
    private String group_name;
}
