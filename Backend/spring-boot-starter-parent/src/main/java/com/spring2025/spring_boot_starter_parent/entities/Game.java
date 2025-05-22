package com.spring2025.spring_boot_starter_parent.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "tb_game")
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera id Automatico
    private Long id;
    private String title;

    @Column(name = "game_year") // customizando nome no banco
    private String year;
    private String genre;
    private String platforms;
    private String score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

}
