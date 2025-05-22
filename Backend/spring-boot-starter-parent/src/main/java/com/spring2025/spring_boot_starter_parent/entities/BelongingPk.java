package com.spring2025.spring_boot_starter_parent.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Embeddable // Encapsulando dois atributos em uma class só
public class BelongingPk {

    @ManyToOne // Relaçaõ de Muitos para um
    @JoinColumn(name = "game_id") // nome da chave estrangeira
    private Game game;

    @ManyToOne // Relaçaõ de Muitos para um
    @JoinColumn(name = "list_id") // nome da chave estrangeira
    private GameList list;
}
