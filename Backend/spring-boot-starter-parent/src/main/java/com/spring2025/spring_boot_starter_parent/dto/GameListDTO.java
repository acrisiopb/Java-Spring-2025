package com.spring2025.spring_boot_starter_parent.dto;

import com.spring2025.spring_boot_starter_parent.entities.GameList;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

}
