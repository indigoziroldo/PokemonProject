package net.niantic.pokemon.application.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "bag", schema = "public")
public class BagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "bag")
    private Set<ItemsEntity> items;

    @Column(name = "color")
    private String color;
}
