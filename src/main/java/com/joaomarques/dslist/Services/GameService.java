package com.joaomarques.dslist.Services;

import com.joaomarques.dslist.DTO.GameMinDTO;
import com.joaomarques.dslist.Entities.Game;
import com.joaomarques.dslist.Repositories.GameRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service // Registrando essa classe como um componente do sistema (poderia ser @Component)
public class GameService {
    
    @Autowired
    private GameRepository gameRepository; // Injetando uma instância do GameRepository no GameService

    public List<GameMinDTO> findAll() { // Método que retorna uma lista de todos os jogos
        List<Game> result = gameRepository.findAll(); // Chamando o método findAll do GameRepository
        return result.stream().map(x -> new GameMinDTO(x)).toList(); // Transformando o objeto para a classe DTO e convertendo em uma lista
    }
}
