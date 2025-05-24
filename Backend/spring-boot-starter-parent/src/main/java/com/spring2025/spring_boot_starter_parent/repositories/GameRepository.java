package com.spring2025.spring_boot_starter_parent.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring2025.spring_boot_starter_parent.entities.Game;
import com.spring2025.spring_boot_starter_parent.projections.GameMinProjection;

/*
 * Interface que herda JpaRepository e fornece operações padrão de acesso a dados (CRUD) para a entidade Game.
 * O JpaRepository<Game, Long> define que a entidade gerenciada é Game e que sua chave primária é do tipo Long.
 * Com isso, não é necessário implementar métodos como findAll(), save(), deleteById(), etc., pois o Spring Data JPA gera automaticamente.
 */
public interface GameRepository extends JpaRepository<Game, Long> {

    /*
     * Consulta nativa (nativeQuery = true) que busca os jogos associados a uma
     * determinada lista (list_id).
     * Retorna dados projetados no formato da interface GameMinProjection.
     * A consulta realiza um INNER JOIN entre tb_game e tb_belonging para obter a
     * posição dos jogos dentro da lista.
     * Campos como game_year, img_url e short_description são renomeados para manter
     * o padrão camelCase no Java.
     * O resultado é ordenado pela posição do jogo na lista.
     */
    @Query(nativeQuery = true, value = """
            SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
            tb_game.short_description AS shortDescription, tb_belonging.position
            FROM tb_game
            INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
            WHERE tb_belonging.list_id = :listId
            ORDER BY tb_belonging.position
            	""")
    List<GameMinProjection> searchByList(Long listId);
}
