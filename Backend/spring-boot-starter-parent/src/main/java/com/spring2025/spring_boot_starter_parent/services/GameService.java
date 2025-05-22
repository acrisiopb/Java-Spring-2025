package com.spring2025.spring_boot_starter_parent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring2025.spring_boot_starter_parent.dto.GameMinDTO;
import com.spring2025.spring_boot_starter_parent.entities.Game;
import com.spring2025.spring_boot_starter_parent.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository; // Injeção

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;

    }

}
