package com.spring2025.spring_boot_starter_parent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring2025.spring_boot_starter_parent.dto.GameDTO;
import com.spring2025.spring_boot_starter_parent.dto.GameListDTO;
import com.spring2025.spring_boot_starter_parent.dto.GameMinDTO;
import com.spring2025.spring_boot_starter_parent.dto.ReplacementDTO;
import com.spring2025.spring_boot_starter_parent.entities.Game;
import com.spring2025.spring_boot_starter_parent.services.GameListService;
import com.spring2025.spring_boot_starter_parent.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gamelistService;

    @Autowired
    private GameService gameService;

    // Retorna toda lista de games
    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> resut = gamelistService.findAll();
        return resut;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> resut = gameService.findByList(listId);
        return resut;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void movie(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gamelistService.move(listId, body.getSourceIndex(), body.getDestinationIndex());

    }
}
