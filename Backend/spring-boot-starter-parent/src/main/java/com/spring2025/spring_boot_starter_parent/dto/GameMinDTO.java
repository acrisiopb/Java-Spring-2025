package com.spring2025.spring_boot_starter_parent.dto;

import com.spring2025.spring_boot_starter_parent.entities.Game;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class GameMinDTO {
    private Long id;
    private String title;
    private String year;
    private String imgUrl;
    private String shortDescription;

    // Construtor personalizado baseado na entidade Game
    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

}
