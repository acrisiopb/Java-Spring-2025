package com.spring2025.spring_boot_starter_parent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring2025.spring_boot_starter_parent.dto.GameDTO;
import com.spring2025.spring_boot_starter_parent.dto.GameListDTO;
import com.spring2025.spring_boot_starter_parent.dto.GameMinDTO;
import com.spring2025.spring_boot_starter_parent.entities.Game;
import com.spring2025.spring_boot_starter_parent.entities.GameList;
import com.spring2025.spring_boot_starter_parent.repositories.GameListRepository;
import com.spring2025.spring_boot_starter_parent.repositories.GameRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository; // Injeção

    // Buscar Todos os Games
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;

    }

}
