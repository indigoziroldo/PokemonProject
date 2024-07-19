package net.niantic.pokemon.application.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import net.niantic.pokemon.application.domain.entities.enums.Type;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items",schema = "public")
public class ItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "basePower")
    private BigDecimal basePower;

    @ManyToOne
    @JoinColumn(name = "id_bag", nullable = false)
    private BagEntity bag;
}
