package com.spring2025.spring_boot_starter_parent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring2025.spring_boot_starter_parent.dto.GameDTO;
import com.spring2025.spring_boot_starter_parent.dto.GameMinDTO;
import com.spring2025.spring_boot_starter_parent.entities.Game;
import com.spring2025.spring_boot_starter_parent.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    // Retorbna Game por id
    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }

    // Retorna toda lista de games
    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> resut = gameService.findAll();
        return resut;
    }
}
