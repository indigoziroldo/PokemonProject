package net.niantic.pokemon.application.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "trainer")
public class TrainerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String name;

    @Column
    private Long pokeballs;

    @OneToMany(mappedBy = "trainer")
    private Set<BatalhaEntity> batalhas;

}
