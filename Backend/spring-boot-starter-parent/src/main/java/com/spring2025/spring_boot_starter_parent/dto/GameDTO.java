package com.spring2025.spring_boot_starter_parent.dto;

import org.springframework.beans.BeanUtils;

import com.spring2025.spring_boot_starter_parent.entities.Game;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class GameDTO {
    private Long id;
    private String title;
    private String year;
    private String genre;
    private String platforms;
    private String score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    // Construtor personalizado baseado na entidade Game
    public GameDTO(Game entity) {
        /*
         * Utiliza o utilitário do Spring BeanUtils para copiar automaticamente os
         * valores
         * dos atributos com o mesmo nome e tipo da entidade 'Game' para este DTO.
         * Isso evita a necessidade de atribuir manualmente cada campo.
         */
        BeanUtils.copyProperties(entity, this); // O this se referencia a Esse DTO
    }

}
