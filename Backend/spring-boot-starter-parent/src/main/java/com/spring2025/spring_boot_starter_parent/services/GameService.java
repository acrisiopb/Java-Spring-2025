package com.spring2025.spring_boot_starter_parent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring2025.spring_boot_starter_parent.dto.GameDTO;
import com.spring2025.spring_boot_starter_parent.dto.GameMinDTO;
import com.spring2025.spring_boot_starter_parent.entities.Game;
import com.spring2025.spring_boot_starter_parent.projections.GameMinProjection;
import com.spring2025.spring_boot_starter_parent.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository; // Injeção

    // Buscar Games por Id
    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    // Buscar GamesList por Id
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();

    }

    // Buscar Todos os Games
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;

    }

}
