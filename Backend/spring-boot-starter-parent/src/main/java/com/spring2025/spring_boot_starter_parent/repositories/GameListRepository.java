package com.spring2025.spring_boot_starter_parent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.spring2025.spring_boot_starter_parent.entities.Game;
import com.spring2025.spring_boot_starter_parent.entities.GameList;

/* Interface que herda JpaRepository e fornece operações padrão de acesso a dados (CRUD) para a entidade Game.
 O JpaRepository<Game, Long> define que a entidade gerenciada é Game e que sua chave primária é do tipo Long.
 Com isso, não é necessário implementar métodos como findAll(), save(), deleteById(), etc., pois o Spring Data JPA gera automaticamente. */
public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);

}