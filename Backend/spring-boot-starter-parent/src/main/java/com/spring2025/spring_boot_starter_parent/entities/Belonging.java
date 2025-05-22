package com.spring2025.spring_boot_starter_parent.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_belonging")
public class Belonging {

    /*
     * A anotação @EmbeddedId é usada para representar uma chave primária composta.
     * Neste caso, a classe BelongingPk encapsula os campos que juntos formam a
     * chave primária da entidade Belonging.
     * Isso é útil quando a tabela possui uma chave composta por mais de uma coluna
     * (ex: id de Game + id de List).
     * A classe BelongingPk deve ser anotada com @Embeddable e conter os atributos
     * da chave, além de equals() e hashCode() corretamente implementados.
     */
    @EmbeddedId
    private BelongingPk id = new BelongingPk();

    private Integer position;

    public Belonging(Game game, GameList list, Integer position) {
        id.setGame(game);
        id.setList(list);
        this.position = position;
    }
}
