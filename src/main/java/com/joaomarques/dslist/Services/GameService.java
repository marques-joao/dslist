package com.joaomarques.dslist.Services;

import com.joaomarques.dslist.DTO.GameDTO;
import com.joaomarques.dslist.DTO.GameMinDTO;
import com.joaomarques.dslist.Entities.Game;
import com.joaomarques.dslist.Repositories.GameRepository;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Registrando essa classe como um componente do sistema (poderia ser @Component)
public class GameService {
    
    @Autowired
    private GameRepository gameRepository; // Injetando uma instância do GameRepository no GameService

    @Transactional
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result); // Convertendo o resultado em um objeto GameDTO
    }

    @Transactional
    public List<GameMinDTO> findAll() { // Método que retorna uma lista de todos os jogos
        List<Game> result = gameRepository.findAll(); // Chamando o método findAll() do GameRepository
        return result.stream().map(x -> new GameMinDTO(x)).toList(); // Transformando o objeto para a classe DTO e convertendo em uma lista
    }
}
