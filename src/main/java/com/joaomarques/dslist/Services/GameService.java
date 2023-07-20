package com.joaomarques.dslist.Services;

import com.joaomarques.dslist.DTO.GameDTO;
import com.joaomarques.dslist.DTO.GameMinDTO;
import com.joaomarques.dslist.Entities.Game;
import com.joaomarques.dslist.Projections.GameMinProjection;
import com.joaomarques.dslist.Repositories.GameRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service // Registrando essa classe como um componente do sistema (poderia ser @Component)
public class GameService {
    
    @Autowired // Anotação que instancia o objeto (equivalente a GameRepository gameRepository = new GameRepository())
    private GameRepository gameRepository; // Injetando uma instância do GameRepository no GameService

    @Transactional(readOnly = true) // Anotação do Spring, com readOnly = true, indica que é um método apenas de leitura
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result); // Convertendo o resultado em um objeto GameDTO
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() { // Método que retorna uma lista de todos os jogos
        List<Game> result = gameRepository.findAll(); // Chamando o método findAll() do GameRepository
        return result.stream().map(x -> new GameMinDTO(x)).toList(); // Transformando o objeto para a classe DTO e convertendo em uma lista
    }
    
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) { // Método que retorna todos os jogos de uma determinada lista
        List<GameMinProjection> result = gameRepository.searchByList(listId); // Chamando o método searchByList() do GameRepository
        return result.stream().map(x -> new GameMinDTO(x)).toList(); // Transformando o objeto para a classe DTO e convertendo em uma lista
    }
    
}